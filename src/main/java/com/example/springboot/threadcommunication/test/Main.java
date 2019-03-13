package com.example.springboot.threadcommunication.test;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/12  15:06
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Main {
    public static void main(String[] args) {
        Num num = new Num();

        Thread t1 = new Thread(new JiNum(num));
        Thread t2 = new Thread(new OuNum(num));
        t1.start();
        t2.start();

    }
}
