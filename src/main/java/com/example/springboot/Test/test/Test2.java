package com.example.springboot.Test.test;

import com.example.springboot.dao.domain.Person;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/25  19:30
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Test2 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setAge(20);
        Person p2 = new Person();
        p2.setAge(25);
        Person p3 = new Person();
        p3.setAge(15);
        Person p4 = new Person();
        p4.setAge(30);
        List<Person> list = new ArrayList<>();
        for (int i =0; i< 10000; i++) {
            Person p = new Person();
            p.setAge(i);
            list.add(p);
        }


        List<Person> list1 = new ArrayList<>();
        list1.add(p1);
        StopWatch watch = new StopWatch();
        watch.start();
//        for (Person p : list) {
//           if (p.getAge() >= 25) {
//               list1.add(p);
//           }
//        }
        list1.addAll(list.stream().filter(item -> item.getAge() >= 25).collect(Collectors.toList()));
        watch.stop();
        watch.prettyPrint();
        System.out.println(watch.getTotalTimeMillis());
        System.out.println(list1);

    }


}
