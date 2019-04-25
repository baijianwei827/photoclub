package com.photo.common.enmus;

public class JwtEnum {
    /**
     * 发行者
     */
    public static final String SUBJECT = "Photo Hub";
    /**
     * 密钥
     */
    public static final String SECRET = "photo:jwt";

    /**
     * 有效时长
     */
    public static final long EXPIRE = 1000*60*60*24*2;

}
