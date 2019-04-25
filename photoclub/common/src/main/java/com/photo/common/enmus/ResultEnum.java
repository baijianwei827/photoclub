package com.photo.common.enmus;

public enum ResultEnum {
    /**
     * 登陆枚举
     */
    USER_NOT_FIND(20001,"该用户不存在!"),
    ERROR_ACCOUNT_OR_PASSWORD(20002,"账号或密码错误!"),
    ERROR_PASSWORD(20002,"密码错误!"),
    ACCOUNT_BAN(20003,"账号已经被禁用!"),
    INVALID_ACCOUNT(200004,"手机号不存在!"),
    INVALID_TOKEN(20005,"非法Token!"),
    LOGIN_SUCCESS(20006,"登陆成功!"),

    /**
     * 注册枚举
     */
    ACCOUNT_EXIST(20007,"账号已被注册!"),
    ACCOUNT_NOT_EXIST(20007,"账号未被注册!"),
    REGISTER_SUCCESS(20008,"注册成功!"),
    ERROR_VERIFICATION_CODE(20009,"验证码错误!"),
    REGISTER_ERROR(20010,"注册失败!"),

    /**
     * 错误枚举
     */
    SEND_CODE_ERROR(100011,"验证码发送失败!"),
    ATTENTION_ERROR(10014,"关注失败!"),
    NOT_ATTENTION_ERROR(10014,"无关注记录!"),
    CANCEL_ATTENTION_ERROR(20015,"取消关注异常!"),
    ADD_ERROR(20016,"添加失败!"),
    DELETE_ERROR(20017,"删除失败!"),


    UNKNOW_ERROR(100000, "未知异常"),
    UPDATE_ERROR(100003,"更改失败!"),
    ILLEGAL_ARGUMENT(100001, "参数无效"),
    PARAMTER_NOT_NULL(100001, "参数不能为空!"),
    SELECT_ERROR(100004, "查找失败!"),
    METHOD_NOT_ALLOW(405, "方法不允许访问"),
    PAGE_NOT_FOUND(404, "页面找不到"),
    BAD_REQUEST(400,"客户端请求的语法错误，服务器无法理解"),
    UNSUPPORTED_MEDIA_TYPE(415,"服务器无法处理请求附带的媒体格式"),
    INTANT_ERROR(100001,"网络异常!"),

    /**
     *
     */
    SEND_CODE_SUCCESS(20011,"验证码发送成功!"),
    UPDATE_SUCCESS(20012,"更改成功!"),
    SELECT_SUCCESS(20013,"查找成功!"),
    ATTENTION_SUCCESS(20014,"关注成功!"),
    CANCEL_ATTENTION_SUCCESS(20015,"取消关注!"),
    ADD_SUCCESS(20016,"添加成功!"),
    DELETE_SUCCESS(20017,"删除成功!");
    private int code;
    private String msg;
    ResultEnum(int code,String msg){
       this.code = code;
       this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

}
