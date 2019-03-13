package com.example.springboot.threadcommunication.test;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/12  14:59
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class JiNum implements Runnable {

    Num num;

    public JiNum(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (num) {
            while (num.i <= 200) {
                if (!num.flag) {
                    System.out.println("奇数线程---" + num.i);
                    num.i++;
                    num.flag = true;
                    num.notify();
                } else {
                    try {
                        num.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
