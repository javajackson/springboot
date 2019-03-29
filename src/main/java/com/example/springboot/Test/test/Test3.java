package com.example.springboot.Test.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/27  13:34
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();


        for (int i = 0; i < list.size() -1; i++) {
            for (int j =1; j < list.size()-i; j++) {
                System.out.println("aaaaaa");
            }
        }
    }
}
