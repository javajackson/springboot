package com.example.springboot.Test;

import com.example.springboot.Test.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/13  10:21
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Deserialization {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("a.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
//            Person person = (Person) ois.readObject();
            List<Integer> list = (ArrayList<Integer>) ois.readObject();
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
