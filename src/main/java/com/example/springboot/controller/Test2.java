package com.example.springboot.controller;

import org.springframework.util.Assert;

import java.util.*;

/**
 * @Author: chenglvpeng
 * @Date: 2019/5/8  16:00
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Test2 {
    public static void main(String[] args) {
      Set<Integer> set = new HashSet<>();
      set.add(1);
      if (set.add(1)) {
          System.out.println("11111");
      } else {
          System.out.println("22222");
      }

    }
}
