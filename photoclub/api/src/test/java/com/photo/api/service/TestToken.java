package com.photo.api.service;

import com.photo.common.tools.JwtUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestToken {
    private String token;

    @Test
    public void getToken (){
//        Map<String ,Object> map = new HashMap<>();
//        map.put("u_id","12345");
//        map.put("u_nickName","一粒丿咖啡豆");
//        map.put("u_avatar","image");
//        token = JwtUtils.generateToken(map);
//        System.out.println(token);
    }
    @Test
    public void checkToken(){
//        Map map = JwtUtils.checkToken(token);
//        for(Object key:map.keySet()){
//            System.out.println(key+":"+map.get(key));
//        }
    }
}
