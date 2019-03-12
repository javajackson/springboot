package com.example.springboot.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: chenglvpeng
 * @Date: 2019/1/23  15:15
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Component("redisUtil")
public class RedisUtil {

    @Autowired
    private StringRedisTemplate template;

    public void setKey(String key, String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key, value, 1, TimeUnit.MINUTES);
    }

    public String getValue(String key){
        ValueOperations<String, String> ops = template.opsForValue();
        return ops.get(key);
    }

}
