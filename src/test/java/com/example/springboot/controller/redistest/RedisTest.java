package com.example.springboot.controller.redistest;

import com.example.springboot.common.enumeration.RedisExpireEnum;
import com.example.springboot.common.enumeration.RedisIndexEnum;
import com.example.springboot.controller.BaseControllerTest;
import com.example.springboot.service.redis.IRedisCache;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/14  14:07
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */

public class RedisTest extends BaseControllerTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    IRedisCache redisCache;

    @Test
    public void t1(){
        ((LettuceConnectionFactory) this.redisTemplate.getConnectionFactory()).setDatabase(5);
        ((LettuceConnectionFactory) this.redisTemplate.getConnectionFactory()).resetConnection();
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        stringStringValueOperations.set("testkey","testvalue");
        String testkey = stringStringValueOperations.get("testkey");
        System.out.println(testkey);

    }


    @Test
    public void t2(){
        ((LettuceConnectionFactory) this.redisTemplate.getConnectionFactory()).setDatabase(3);
        ((LettuceConnectionFactory) this.redisTemplate.getConnectionFactory()).resetConnection();
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        stringStringValueOperations.set("testkey","testvalue");
        String testkey = stringStringValueOperations.get("testkey");
        System.out.println(testkey);

    }

    @Test
    public void t3() {
        for (int i = 0; i <= 2; i++) {
            ((LettuceConnectionFactory) this.redisTemplate.getConnectionFactory()).setDatabase(i);
            ((LettuceConnectionFactory) this.redisTemplate.getConnectionFactory()).resetConnection();
            ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
            stringStringValueOperations.set("testkey" + i,"testvalue" + i);
            String testkey = stringStringValueOperations.get("testkey" + i);
            System.out.println(testkey);
        }
    }

    @Test
    public void test4() {
        String secondKey = "secondKey";
        Map<String,Object> data = new HashMap<>();
        data.put("aa","aaa");
        data.put("bb","bbb");

        redisCache.hSetAll(RedisIndexEnum.INDEX_4,secondKey, data, RedisExpireEnum.EXPIRE_FOREVER);
        Map<Object, Object> result = redisCache.hGetAll(RedisIndexEnum.INDEX_4,secondKey);

        System.out.println(result);

    }

    @Test
    public void test5() {
        String secondKey = "secondKey";
        Map<Object, Object> result = redisCache.hGetAll(RedisIndexEnum.INDEX_4,secondKey);

        System.out.println(result);
    }


}
