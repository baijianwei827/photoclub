package com.photo.dao.domain;

import java.util.Date;

public class User {
    /**
     * 主键 u_id
     */
    private String u_id;

    /**
     * 账号(手机) u_account
     */
    private String u_account;

    /**
     * 密码 u_password
     */
    private String u_password;

    /**
     * 昵称 u_nickName
     */
    private String u_nickName;

    /**
     * 头像 u_avatar
     */
    private String u_avatar;

    /**
     * 是否禁用0：不禁用1：禁用 u_isfalse
     */
    private Integer u_isfalse;

    /**
     * 职业 u_profession
     */
    private String u_profession;

    /**
     * 爱好 u_hobby
     */
    private String u_hobby;

    /**
     * 省 u_province
     */
    private String u_province;

    /**
     * 市 u_city
     */
    private String u_city;

    /**
     * 是否置顶 is_Top
     */
    private Integer is_Top;

    /**
     * 置顶时间 top_time
     */
    private Date top_time;

    /**
     * 是否是新用户0:不是，1:是 is_new
     */
    private Integer is_new;

    /**
     * 创建时间 u_createTime
     */
    private Date u_createTime;

    /**
     * 是否是达人0：不是，1是 u_type
     */
    private Integer u_type;

    /**
     * 关注个数 attention_number
     */
    private Integer attention_number;

    /**
     * 粉丝人数 fans_number
     */
    private Integer fans_number;

    /**
     * 个人介绍 u_introduce
     */
    private String u_introduce;

    private String u_code;

    public String getU_code() {
        return u_code;
    }

    public void setU_code(String u_code) {
        this.u_code = u_code;
    }

    /**
     * 主键
     * @author zw221
     * @return u_id 主键
     */
    public String getU_id() {
        return u_id;
    }

    /**
     * 主键
     * @author zw221
     * @param u_id 主键
     */
    public void setU_id(String u_id) {
        this.u_id = u_id == null ? null : u_id.trim();
    }

    /**
     * 账号(手机)
     * @author zw221
     * @return u_account 账号(手机)
     */
    public String getU_account() {
        return u_account;
    }

    /**
     * 账号(手机)
     * @author zw221
     * @param u_account 账号(手机)
     */
    public void setU_account(String u_account) {
        this.u_account = u_account == null ? null : u_account.trim();
    }

    /**
     * 密码
     * @author zw221
     * @return u_password 密码
     */
    public String getU_password() {
        return u_password;
    }

    /**
     * 密码
     * @author zw221
     * @param u_password 密码
     */
    public void setU_password(String u_password) {
        this.u_password = u_password == null ? null : u_password.trim();
    }

    /**
     * 昵称
     * @author zw221
     * @return u_nickName 昵称
     */
    public String getU_nickName() {
        return u_nickName;
    }

    /**
     * 昵称
     * @author zw221
     * @param u_nickName 昵称
     */
    public void setU_nickName(String u_nickName) {
        this.u_nickName = u_nickName == null ? null : u_nickName.trim();
    }

    /**
     * 头像
     * @author zw221
     * @return u_avatar 头像
     */
    public String getU_avatar() {
        return u_avatar;
    }

    /**
     * 头像
     * @author zw221
     * @param u_avatar 头像
     */
    public void setU_avatar(String u_avatar) {
        this.u_avatar = u_avatar == null ? null : u_avatar.trim();
    }

    /**
     * 是否禁用0：不禁用1：禁用
     * @author zw221
     * @return u_isfalse 是否禁用0：不禁用1：禁用
     */
    public Integer getU_isfalse() {
        return u_isfalse;
    }

    /**
     * 是否禁用0：不禁用1：禁用
     * @author zw221
     * @param u_isfalse 是否禁用0：不禁用1：禁用
     */
    public void setU_isfalse(Integer u_isfalse) {
        this.u_isfalse = u_isfalse;
    }

    /**
     * 职业
     * @author zw221
     * @return u_profession 职业
     */
    public String getU_profession() {
        return u_profession;
    }

    /**
     * 职业
     * @author zw221
     * @param u_profession 职业
     */
    public void setU_profession(String u_profession) {
        this.u_profession = u_profession == null ? null : u_profession.trim();
    }

    /**
     * 爱好
     * @author zw221
     * @return u_hobby 爱好
     */
    public String getU_hobby() {
        return u_hobby;
    }

    /**
     * 爱好
     * @author zw221
     * @param u_hobby 爱好
     */
    public void setU_hobby(String u_hobby) {
        this.u_hobby = u_hobby == null ? null : u_hobby.trim();
    }

    /**
     * 省
     * @author zw221
     * @return u_province 省
     */
    public String getU_province() {
        return u_province;
    }

    /**
     * 省
     * @author zw221
     * @param u_province 省
     */
    public void setU_province(String u_province) {
        this.u_province = u_province == null ? null : u_province.trim();
    }

    /**
     * 市
     * @author zw221
     * @return u_city 市
     */
    public String getU_city() {
        return u_city;
    }

    /**
     * 市
     * @author zw221
     * @param u_city 市
     */
    public void setU_city(String u_city) {
        this.u_city = u_city == null ? null : u_city.trim();
    }

    /**
     * 是否置顶
     * @author zw221
     * @return is_Top 是否置顶
     */
    public Integer getIs_Top() {
        return is_Top;
    }

    /**
     * 是否置顶
     * @author zw221
     * @param is_Top 是否置顶
     */
    public void setIs_Top(Integer is_Top) {
        this.is_Top = is_Top;
    }

    /**
     * 置顶时间
     * @author zw221
     * @return top_time 置顶时间
     */
    public Date getTop_time() {
        return top_time;
    }

    /**
     * 置顶时间
     * @author zw221
     * @param top_time 置顶时间
     */
    public void setTop_time(Date top_time) {
        this.top_time = top_time;
    }

    /**
     * 是否是新用户0:不是，1:是
     * @author zw221
     * @return is_new 是否是新用户0:不是，1:是
     */
    public Integer getIs_new() {
        return is_new;
    }

    /**
     * 是否是新用户0:不是，1:是
     * @author zw221
     * @param is_new 是否是新用户0:不是，1:是
     */
    public void setIs_new(Integer is_new) {
        this.is_new = is_new;
    }

    /**
     * 创建时间
     * @author zw221
     * @return u_createTime 创建时间
     */
    public Date getU_createTime() {
        return u_createTime;
    }

    /**
     * 创建时间
     * @author zw221
     * @param u_createTime 创建时间
     */
    public void setU_createTime(Date u_createTime) {
        this.u_createTime = u_createTime;
    }

    /**
     * 是否是达人0：不是，1是
     * @author zw221
     * @return u_type 是否是达人0：不是，1是
     */
    public Integer getU_type() {
        return u_type;
    }

    /**
     * 是否是达人0：不是，1是
     * @author zw221
     * @param u_type 是否是达人0：不是，1是
     */
    public void setU_type(Integer u_type) {
        this.u_type = u_type;
    }

    /**
     * 关注个数
     * @author zw221
     * @return attention_number 关注个数
     */
    public Integer getAttention_number() {
        return attention_number;
    }

    /**
     * 关注个数
     * @author zw221
     * @param attention_number 关注个数
     */
    public void setAttention_number(Integer attention_number) {
        this.attention_number = attention_number;
    }

    /**
     * 粉丝人数
     * @author zw221
     * @return fans_number 粉丝人数
     */
    public Integer getFans_number() {
        return fans_number;
    }

    /**
     * 粉丝人数
     * @author zw221
     * @param fans_number 粉丝人数
     */
    public void setFans_number(Integer fans_number) {
        this.fans_number = fans_number;
    }

    /**
     * 个人介绍
     * @author zw221
     * @return u_introduce 个人介绍
     */
    public String getU_introduce() {
        return u_introduce;
    }

    /**
     * 个人介绍
     * @author zw221
     * @param u_introduce 个人介绍
     */
    public void setU_introduce(String u_introduce) {
        this.u_introduce = u_introduce == null ? null : u_introduce.trim();
    }

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", u_id=").append(u_id);
        sb.append(", u_account=").append(u_account);
        sb.append(", u_password=").append(u_password);
        sb.append(", u_nickName=").append(u_nickName);
        sb.append(", u_avatar=").append(u_avatar);
        sb.append(", u_isfalse=").append(u_isfalse);
        sb.append(", u_profession=").append(u_profession);
        sb.append(", u_hobby=").append(u_hobby);
        sb.append(", u_province=").append(u_province);
        sb.append(", u_city=").append(u_city);
        sb.append(", is_Top=").append(is_Top);
        sb.append(", top_time=").append(top_time);
        sb.append(", is_new=").append(is_new);
        sb.append(", u_createTime=").append(u_createTime);
        sb.append(", u_type=").append(u_type);
        sb.append(", attention_number=").append(attention_number);
        sb.append(", fans_number=").append(fans_number);
        sb.append(", u_introduce=").append(u_introduce);
        sb.append("]");
        return sb.toString();
    }
}