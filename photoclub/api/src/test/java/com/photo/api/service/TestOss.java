package com.photo.api.service;

import com.photo.api.aliyunoss.AliyunOSSUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestOss {
    @Test
    public void uploadImage(){
//        Resource resource = new ClassPathResource("image/one.jpg");
//        try {
//            File file = resource.getFile();
//            System.out.println(AliyunOSSUtil.upload(file));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
