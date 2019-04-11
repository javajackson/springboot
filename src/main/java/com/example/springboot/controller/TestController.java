package com.example.springboot.controller;

import com.example.springboot.dao.domain.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenglvpeng
 * @Date: 2019/4/11  13:32
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello5(@RequestBody Person person) {
      return "";
    }
}
