package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: chenglvpeng
 * @Date: 2019/5/30  11:12
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
public class Test2Controller {

    @RequestMapping("/test2/test")
    public void test(HttpServletRequest request) {
        try {
            InputStream stream = request.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
