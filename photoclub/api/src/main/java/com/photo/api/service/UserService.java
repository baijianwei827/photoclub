package com.photo.api.service;

import com.photo.api.params.UserParams;
import com.photo.common.results.Result;
import com.photo.dao.domain.User;

import java.util.List;

public interface UserService {

    /**
     * 用户登陆
     * @param account
     * @param password
     * @return
     */
    Result login(String account, String password);

    /**
     * 注册用户
     * @param user
     * @return
     */
    Result register(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    Result updateUser(User user);

    /**
     * 发送验证码
     * @param phone
     * @param type 0:注册，1:忘记密码
     * @return
     */
    Result sendCode(String phone,Integer type);

    /**
     * 通过用户ID查找用户
     * @param u_id
     * @return
     */
    Result selectUserById(String u_id);

    /**
     * 推荐用户查找
     * @return
     */
    Result selectUserIsRecommend();


    /**
     * 忘记密码
     * @param u_account
     * @param new_password
     * @return
     */
    Result forgetUserPassword (String u_account,String code,String new_password);

    /**
     * 修改密码
     * @param u_account
     * @param old_password
     * @param new_password
     * @return
     */
    Result updateUserPassword(String u_account,String old_password,String new_password);

    /**
     * 通过用户名称查找并且可以排序
     * @param userParams
     * @return
     */
    Result selectByNickName(UserParams userParams);
}
