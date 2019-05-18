package com.photo.api.service;

import com.photo.api.service.Impl.SpecialServiceImpl;
import com.photo.common.results.Result;
import com.photo.dao.domain.Image;
import com.photo.dao.domain.Special;
import com.photo.dao.repository.ImageMapper;
import com.photo.dao.repository.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SpecialService specialService;
    @Autowired
    private ImageMapper imageMapper;
    @Test
    public void UserTest(){
//        Special special = new Special();
//        special.setSp_id(UUID.randomUUID().toString());
//        special.setU_id("898bde15-a696-42ae-b167-69ac302bdab6");
//        special.setT_id(1);
//        special.setSp_name("少女组合");
//        special.setSp_describe("天真无邪!");
//        special.setI_number(0);
//        special.setImg_cover("http://img1002-c.pocoimg.cn/image/poco/works/38/2019/0417/15/15554855308423522_200934577_W640.jpg?2048");
//        specialService.insertSpecial(special);
//        Image image = new Image();
//        image.setIm_id(UUID.randomUUID().toString());
//        image.setSp_id("9e2f682a-92cc-460b-801d-81f7dd0928c9");
//        image.setU_id("898bde15-a696-42ae-b167-69ac302bdab6");
//        image.setT_id(1);
//        image.setIm_url("http://img1002-c.pocoimg.cn/image/poco/works/81/2019/0417/07/15554583205644364_53752288_H800.jpgg");
//        image.setIm_troduce("繁华似锦");
//        image.setIs_cottect(1);
//        System.out.println(imageMapper.insertSelective(image));
//          Result result = specialService.selectSpecialByU_id("898bde15-a696-42ae-b167-69ac302bdab6",0,0,3);
//          System.out.println(result.getData());
//        System.out.println(userMapper.selelctAllUser());
    }

}