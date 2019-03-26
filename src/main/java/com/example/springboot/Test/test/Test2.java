package com.example.springboot.Test.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/25  19:30
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        a(list);
        System.out.println(list);

    }

    private static void a(List<String> list) {
        list.add("ccc");
    }
}
