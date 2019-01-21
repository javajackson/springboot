package com.example.springboot.dao.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: chenglvpeng
 * @Date: 2019/1/17  15:50
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Component
//@ConfigurationProperties(prefix = "person")
@Data
public class Person1 {

    @Value("${person.lastName}")
    String lastName;

    @Value("${person.age}")
    int age;

    @Value("${person.boss}")
    boolean boss;

    @Value("${person.birth}")
    Date birth;


    Map<String, String> maps;
    @Value("${person.list}")
    List<String> list;

    Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }
}
