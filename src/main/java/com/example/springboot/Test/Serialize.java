package com.example.springboot.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/13  09:55
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Serialize {
    public static void main(String[] args) {

      /*  Person person = new Person();
        person.setAge(30);
        person.setGender('F');
        person.setName("wangwu");*/
      List<Integer> list = new ArrayList<>();
      list.add(1);
      list.add(2);

        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream("a.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
