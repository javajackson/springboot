package com.example.springboot.controller;

import com.example.springboot.dao.UserMapper;
import com.example.springboot.dao.domain.Person;
import com.example.springboot.dao.domain.Person1;
import com.example.springboot.dao.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: chenglvpeng
 * @Date: 2019/1/17  13:46
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class UserControllerTest extends BaseControllerTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    Person person;

    @Test
    public void listUser() {
        List<User> userList =  userMapper.listUser();
        System.out.println(userList);
        System.out.println(person);
    }


}