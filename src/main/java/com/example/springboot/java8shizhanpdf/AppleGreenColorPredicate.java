package com.example.springboot.java8shizhanpdf;

import com.example.springboot.java8shizhanpdf.domain.Apple;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/28  19:56
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("green");
    }
}
