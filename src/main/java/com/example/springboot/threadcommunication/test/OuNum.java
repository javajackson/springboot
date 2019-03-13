package com.example.springboot.threadcommunication.test;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/12  15:04
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class OuNum implements Runnable {
    Num num;

    public OuNum(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (num) {
            while (num.i <= 200) {
                if (num.flag) {
                    System.out.println("偶数线程---" + num.i);
                    num.i++;
                    num.flag = false;
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
