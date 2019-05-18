package com.photo.api.controller;

import com.photo.api.params.UserParams;
import com.photo.api.service.UserService;
import com.photo.common.results.Result;
import com.photo.dao.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@Api(value = "用户接口API")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登陆接口
     * @param user
     * @return
     */
    @PostMapping(value = "login")
    @ApiOperation(value = "登陆接口",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name="User",value = "{账号,密码}",dataType = "User",required = true)
    })
    public Result login (@RequestBody User user){
        return userService.login(user.getU_account(),user.getU_password());
    }

    @PostMapping("register")
    @ApiOperation(value = "注册接口",httpMethod = "POST")
    @ApiImplicitParam(name = "User",value = "用户对象",dataType = "User",required = true)
    public Result register(@RequestBody User user){
        return userService.register(user);
    }

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    @PutMapping(value = "token/update")
    @ApiOperation(value = "修改个人信息接口",httpMethod = "PUT")
    @ApiImplicitParam(name = "user",value = "用户对象",dataType = "User",required = true)
    public Result updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    /**
     * 发送验证码：0:注册，1:忘记密码
     * @param phone
     * @param type
     * @return
     */
    @GetMapping("code/{phone}/{type}")
    @ApiOperation(value = "发送验证码接口",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone",value = "手机号码",dataType = "String",required = true),
            @ApiImplicitParam(name = "type",value = " 类型type:0:注册，1:忘记密码",dataType = "Integer",required = true)
    })
    public Result sendCode(@PathVariable(name = "phone") String phone,@PathVariable(name = "type")Integer type){
        return userService.sendCode(phone,type);
    }

    /**
     * 通过用户ID获取用户信息
     * @param u_id
     * @return
     */
    @GetMapping("info/{u_id}")
    @ApiOperation(value = "通过ID获取用户信息",httpMethod = "GET")
    @ApiImplicitParam(name = "u_id",value = "用户的ID",dataType="String",required = true)
    public Result selectUserById(@PathVariable(name="u_id")String u_id){
        return userService.selectUserById(u_id);
    }

    /**
     * 通过用户名称查找用户
     * @return
     */
    @PostMapping("list")
    @ApiOperation(value = "通过用户名称查找用户接口",httpMethod = "POST")
    public Result selectByUserName(@RequestBody UserParams userParams){
        System.out.println(userParams);
       return userService.selectByNickName(userParams);
    }

    /**
     * 首页推荐用户
     * @return
     */
    @GetMapping("token/recommend")
    @ApiOperation(value = "推荐用户接口",httpMethod = "GET")
    public Result selectUserIsRecommend(){
        return userService.selectUserIsRecommend();
    }

    /**
     * 忘记密码
     * @return
     */
    @PostMapping("forget/pwd")
    @ApiOperation(value = "忘记密码接口",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "User",value = "{phone:手机号码,code:验证码,new_password:新密码}",dataType = "User",required = true),
    })
    public Result forgetUserPassword(@RequestBody User user){
        return userService.forgetUserPassword(user.getU_account(),user.getU_code(),user.getU_password());
    }

    /**
     * 修改密码
     * @param map
     * @return
     */
    @PostMapping("token/update/pwd")
    @ApiOperation(value = "忘记密码接口",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Map",value = "{u_account:手机号码,old_password:老密码,new_password:新密码}",dataType = "Map",required = true),
    })
    public Result UpdateUserPassword(@RequestBody Map map){
        return userService.updateUserPassword((String)map.get("u_account"),(String)map.get("old_password"),(String)map.get("new_password"));
    }
}
