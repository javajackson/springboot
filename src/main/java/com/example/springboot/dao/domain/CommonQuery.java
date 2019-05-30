package com.example.springboot.dao.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: chenglvpeng
 * @Date: 2019/4/17  11:30
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonQuery implements Serializable {

    private List<Person> personList;

    private String c;

    @Override
    public String toString() {
        return "CommonQuery{" +
                "personList=" + personList +
                '}';
    }
}
