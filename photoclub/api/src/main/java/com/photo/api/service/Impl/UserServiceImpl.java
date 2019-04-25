package com.photo.api.service.Impl;

import com.photo.api.redis.RedisCode;
import com.photo.api.service.UserService;
import com.photo.common.enmus.ResultEnum;
import com.photo.common.results.Result;
import com.photo.common.results.ResultUtil;
import com.photo.common.tools.JwtUtils;
import com.photo.common.tools.SMSUtils;
import com.photo.common.tools.StringUtil;
import com.photo.dao.domain.User;
import com.photo.dao.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisCode redisCode;

    @Override
    public Result login(String account, String password) {

        //判断是否为手机号
        if(!StringUtil.isMobile(account)){
          return ResultUtil.error(ResultEnum.INVALID_ACCOUNT.getMsg());
        }
        User user = userMapper.selectUserByAccount(account);
        System.out.println(user.toString());
        //判断账号密码是否正确
        if(user == null || !user.getU_password().equals(password)){
            return ResultUtil.error(ResultEnum.ERROR_ACCOUNT_OR_PASSWORD.getMsg());
        }
        //判断用户是否被禁用
        if(user.getU_isfalse() == 1)
            return ResultUtil.error(ResultEnum.ACCOUNT_BAN.getMsg());

        Map<String,Object> map = new HashMap<>();
        map.put("u_id",user.getU_id());
        map.put("u_nickName",user.getU_nickName());
        String token = JwtUtils.generateToken(map);
        // 返回数据
        Map userMap = new HashMap();
        user.setU_password(null);
        userMap.put("user", user);
        userMap.put("token", token);
        return ResultUtil.success(ResultEnum.LOGIN_SUCCESS.getMsg(),userMap);
    }

    @Override
    @Transactional
    public Result register(User user) {
        //判断参数是否为空!
        if(user == null || user.getU_account() == null || user.getU_password() == null){
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        }
        //判断手机号是否存在
        if(!StringUtil.isMobile(user.getU_account())){
            return ResultUtil.error(ResultEnum.INVALID_ACCOUNT.getMsg());
        }
        //判断手机号是否被注册
        if(userMapper.selectUserByAccount(user.getU_account())!=null){
            return ResultUtil.error(ResultEnum.ACCOUNT_EXIST.getMsg());
        }
        //判断验证码是否错误
        if (!redisCode.compareCode(0,user.getU_account(), user.getU_code()))
            return ResultUtil.error(ResultEnum.ERROR_VERIFICATION_CODE.getMsg());
        user.setU_isfalse(0);
        user.setAttention_number(0);
        user.setFans_number(0);
        user.setIs_new(0);
        user.setIs_Top(0);
        user.setU_id(UUID.randomUUID().toString());
//        user.setU_createTime(new Date());
        int n = userMapper.insertSelective(user);
        if(n == 1){
            return ResultUtil.success(ResultEnum.REGISTER_SUCCESS.getMsg(),userMapper.selectUserByAccount(user.getU_account()));
        }else {
            return ResultUtil.error(ResultEnum.REGISTER_ERROR.getMsg());
        }

    }

    @Override
    @Transactional
    public Result updateUser(User user){
        //判断参数是否为空!
        if(user == null
                || user.getU_account() == null
                || user.getU_password() == null
                || user.getU_id() == null
                ||user.getU_nickName() == null){
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        }
        int n =userMapper.updateByPrimaryKeySelective(user);
        User newUser =userMapper.selectByPrimaryKey(user.getU_id());
        if(n == 1)
            return ResultUtil.success(ResultEnum.UPDATE_SUCCESS.getMsg(),newUser);
        return ResultUtil.error(ResultEnum.UPDATE_ERROR.getMsg());
    }

    @Override
    public Result sendCode(String phone, Integer type) {
        //判断参数是否为空!
        if (phone == null || type == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        //判断手机是否有效
        if (!StringUtil.isMobile(phone))
            return ResultUtil.error(ResultEnum.INVALID_ACCOUNT.getMsg());
            //判断返送验证码类型:0:注册,1:忘记密码
        if (type == 0) {
            //判断手机号是否被注册
             User user = userMapper.selectUserByAccount(phone);
             if (user != null)
                 return ResultUtil.error(ResultEnum.ACCOUNT_EXIST.getMsg());
            }
        if (type == 1) {
            //判断手机号是否被注册
            User user = userMapper.selectUserByAccount(phone);
            if (user == null)
                return ResultUtil.error(ResultEnum.ACCOUNT_NOT_EXIST.getMsg());
        }
        String code = StringUtil.randomCode();
        //发送验证码
        if(SMSUtils.sendSMSCode(phone, code, type) == null){
            return ResultUtil.error(ResultEnum.SEND_CODE_ERROR.getMsg());
        }
        //验证码持久化
        redisCode.saveCode(type,phone,code);
        return ResultUtil.success(ResultEnum.SEND_CODE_SUCCESS.getMsg());
    }

    @Override
    public Result selectUserById(String u_id){
        if(u_id == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        User user = userMapper.selectByPrimaryKey(u_id);
        if(user !=null){
            return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),user);
        }
        return ResultUtil.error(ResultEnum.SELECT_ERROR.getMsg());
    }

    @Override
    public Result selectUserIsRecommend(){
         List<User> userList = userMapper.selectUserIsRecommend(1);
         return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),userList);
    }

    @Override
    public Result selectUserByLike(String u_nickName, Integer isDesc){
        List<User> userList = userMapper.selectUserByLikeNickName(u_nickName,isDesc);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),userList);
    }

    @Override
    public Result forgetUserPassword(String u_account,
                                     String code,
                                     String new_password) {
        if(u_account == null || new_password == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        //判断是否已经注册
        User user = userMapper.selectUserByAccount(u_account);
        if (user == null)
            return ResultUtil.error(ResultEnum.ACCOUNT_NOT_EXIST.getMsg());

        if(redisCode.compareCode(1,u_account,code)){
            int n = userMapper.UpdateUserPassword(new_password,u_account);
            if(n == 1)
                return ResultUtil.success(ResultEnum.UPDATE_SUCCESS.getMsg());
            return ResultUtil.error(ResultEnum.UPDATE_ERROR.getMsg());
        }
        return ResultUtil.error(ResultEnum.ERROR_VERIFICATION_CODE.getMsg());
    }

    @Override
    public Result updateUserPassword(String u_account, String old_password, String new_password) {
        if(u_account == null || old_password ==null || new_password == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        //判断是否已经注册
        User user = userMapper.selectUserByAccount(u_account);
        if (user == null)
            return ResultUtil.error(ResultEnum.ACCOUNT_NOT_EXIST.getMsg());
        if(!user.getU_password().equals(old_password))
            return ResultUtil.error(ResultEnum.ERROR_PASSWORD.getMsg());
        int n = userMapper.UpdateUserPassword(new_password,u_account);
        if (n==1)
            return ResultUtil.success(ResultEnum.UPDATE_SUCCESS.getMsg());
        return ResultUtil.success(ResultEnum.UPDATE_ERROR.getMsg());
    }


}
