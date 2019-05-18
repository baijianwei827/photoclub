package com.photo.api.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCode {
    @Autowired
    private RedisUtil redisUtil;
    private static final String CODE_TYPE = ":";
    //设置过期时间
    private static final long TIME = 60*5 ;

    public void saveCode(Integer type,String phone,String code){
         redisUtil.set(type+CODE_TYPE+phone,code,TIME);
    }

    public Object getCode(Integer type,String phone){
       return redisUtil.get(type+CODE_TYPE+phone);
    }
    public void  removeCode(Integer type,String phone){
        redisUtil.del(type+CODE_TYPE+phone);
    }

    public boolean compareCode (Integer type,String phone,String code){
       String redis_code = (String) getCode(type,phone);
       if(redis_code == null)
           return false;
       if (redis_code.equals(code)){
           return true;
       }
       return false;

    }
}
