package com.photo.common.tools;

import com.photo.common.enmus.JwtEnum;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具类
 */
public class JwtUtils {

    /**
     * 创建token
     * @param map
     * @return
     */
    public static String generateToken(Map<String,Object> map){
       if(map == null)  {
           return null;
       }
       String token =  Jwts.builder().setSubject(JwtEnum.SUBJECT) //创建 并 指定发行者
                .setClaims(map) // 设置负载内容
                .setIssuedAt(new Date()) //设置发行时间
                .setExpiration(new Date(System.currentTimeMillis()+ JwtEnum.EXPIRE)) //设置失效时间
                .signWith(SignatureAlgorithm.HS256,JwtEnum.SECRET)
                .compact();
       return token;
    }

    /**
     * 验证token 并获取 负载内容
     * @param token
     * @return
     */
    public static Map checkToken(String token){
        try{
            Map map =  Jwts.parser().setSigningKey(JwtEnum.SECRET)//放入私钥
                    // 获取负载的值
                    .parseClaimsJws(token).getBody();
            return map;
        }catch (Exception e) {
            System.out.println("非法token!");
            return null;
        }
    }

}
