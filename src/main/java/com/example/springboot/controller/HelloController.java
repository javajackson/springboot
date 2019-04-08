package com.example.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenglvpeng
 * @Date:2018/11/28 13:55
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
public class HelloController {

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String index() throws InterruptedException {
        logger.info("/hello start");
        StopWatch watch = new StopWatch("/hello:");
        watch.start();
        Thread.sleep(2000);
        watch.stop();
        System.out.println(watch.prettyPrint());
        logger.info("/hello end, it takes " + watch.getTotalTimeMillis() + "ms");
        return helloService.hello();
    }
    @RequestMapping("/hello2")
    public String index2(){
        return "hello2";
    }
    @RequestMapping("/hello3")
    public String index3(){
        return "hello3";
    }

    @RequestMapping("/hello4")
    public String hello4(@RequestBody String body) {

        JSONObject object = JSONObject.parseObject(body);
        String userId = object.getString("userId");
        String password = object.getString("password");
        Integer age = object.getInteger("age");
        System.out.println(userId + "," + password + "," + age);
        System.out.println(body);
        return "";

    }
}
