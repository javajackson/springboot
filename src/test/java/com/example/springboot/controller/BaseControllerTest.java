package com.example.springboot.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Author: chenglvpeng
 * @Date: 2019/1/17  14:08
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BaseControllerTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("start test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("finish test");
    }

}
