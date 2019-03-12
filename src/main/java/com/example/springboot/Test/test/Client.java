package com.example.springboot.Test.test;

/**
 * @Author: chenglvpeng
 * @Date: 2019/2/19  10:05
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        receiver.execute();
    }
}
