package com.example.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.Test.Person;
import com.example.springboot.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenglvpeng
 * @Date: 2019/4/4  18:06
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
public class CacheController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/a")
    public String a() {
        Person p1 = new Person();
        p1.setName("11");
        p1.setAge(11);
        p1.setGender('M');
        Person p2 = new Person();
        p2.setName("22");
        p2.setAge(22);
        p2.setGender('F');
        Person p3 = new Person();
        p3.setName("33");
        p3.setAge(33);
        p3.setGender('F');
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        redisUtil.listPushAll("test", list, 100000L);

        List list2 = redisUtil.listGetAll("test");
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < list2.size(); i++) {
            JSONObject object = (JSONObject)list2.get(i);
            if (null != object) {
                people.add(object.toJavaObject(Person.class));
            }
        }
        for (Person p : people) {
            System.out.println(p.getAge() + "," + p.getGender() + "," + p.getGender());
        }
        return "a";
    }
}
