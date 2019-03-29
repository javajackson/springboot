package com.example.springboot.java8shizhanpdf.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/28  19:30
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Apple {
    private String color;
    private Integer weight;

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }
}
