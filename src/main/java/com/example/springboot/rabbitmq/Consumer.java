package com.example.springboot.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/11  09:56
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("localhost");

        //建立到代理服务器连接
        Connection conn = factory.newConnection();
        //获得信道
        final Channel channel = conn.createChannel();
        //声明交换器
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, "direct", true);

        //声明队列
        String queueName = channel.queueDeclare().getQueue();
        String routingKey = "hola";
        //绑定队列，通过hola将队列和交换器绑定起来
        channel.queueBind(queueName, exchangeName, routingKey);

        while (true) {
            boolean autoAck = false;
            String consumerTag = "";
            channel.basicConsume(queueName, autoAck, consumerTag, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String routingKey = envelope.getRoutingKey();
                    String contentType = properties.getContentType();
                    System.out.println("消费的路邮键：" + routingKey);
                    System.out.println("消费的内容类型" + contentType);
                    long deliverTag = envelope.getDeliveryTag();
                    //确认消息
                    channel.basicAck(deliverTag, false);
                    System.out.println("消费的消息体内容：");
                    String bodyStr = new String(body, "utf-8");
                    System.out.println(bodyStr);

                }
            });
        }

    }
}
