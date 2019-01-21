package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenglvpeng
 * @Date:2018/11/28 13:55
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
public class HelloController {



    @RequestMapping("/hello")
    public String index(){
        return "f";
    }
    @RequestMapping("/hello2")
    public String index2(){
        return "hello2";
    }
    @RequestMapping("/hello3")
    public String index3(){
        return "hello3";
    }
}
