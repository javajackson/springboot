package com.example.springboot.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/11  09:48
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        //设置MQ地址
        factory.setHost("localhost");
        //建立代理服务器连接
        Connection connection = factory.newConnection();
        //获得信道
        Channel channel = connection.createChannel();
        //声明交换器
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, "direct", true);

        String routingKey = "hola";

        //发布消息
        byte[] messageBodyBytes = "quitqqq".getBytes("UTF-8");
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);

        channel.close();
        connection.close();

    }
}
