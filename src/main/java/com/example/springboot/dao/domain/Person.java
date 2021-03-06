package com.example.springboot.dao.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@ConfigurationProperties(prefix = "person")
@Data
public class Person implements Serializable {

    String lastName;

    int age;

    boolean boss;

    Date birth;

    Map<String, String> maps;

    @JsonProperty("someSingleValuedField")
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
