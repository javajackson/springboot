package com.example.springboot.service.redis;

import com.example.springboot.common.enumeration.RedisExpireEnum;
import com.example.springboot.common.enumeration.RedisIndexEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/14  14:54
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Service("redisCache")
public class RedisCacheImpl implements IRedisCache {

    private static final Logger logger = LoggerFactory.getLogger(RedisCacheImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Long hSetAll(RedisIndexEnum dbIndexEnum, String key, Map<String, Object> hashMap, RedisExpireEnum seconds) {
        Long result = null;


        try {
            // 切换redis仓库
            ((LettuceConnectionFactory) this.redisTemplate.getConnectionFactory()).setDatabase(dbIndexEnum.getIndex());
            ((LettuceConnectionFactory) this.redisTemplate.getConnectionFactory()).resetConnection();
            redisTemplate.setEnableTransactionSupport(true);
            this.redisTemplate.multi();
            this.del(dbIndexEnum,key);
            this.redisTemplate.opsForHash().putAll(key, hashMap);
            this.redisTemplate.expire(key, seconds.getSeconds(), TimeUnit.SECONDS);
            this.redisTemplate.exec();
            System.out.println("hSetAll 执行完毕！");
        } catch (Exception e) {
            logger.error("hSetAll e:{}", e);
        }
        return result;
    }

    @Override
    public Map<Object, Object> hGetAll(RedisIndexEnum dbIndexEnum, String key) {

        try {
            // 切换redis仓库


            ((LettuceConnectionFactory) redisTemplate.getConnectionFactory()).setDatabase(dbIndexEnum.getIndex());
            ((LettuceConnectionFactory) this.redisTemplate.getConnectionFactory()).resetConnection();
            System.out.println("hGetAll 开始执行！");
            return redisTemplate.opsForHash().entries(key);
        } catch (Exception e) {
            logger.error("hGetAll e:{}", e);
        }
        return null;
    }

    @Override
    public void del(RedisIndexEnum dbIndexEnum, String key) {
        try {
            // 切换redis仓库
            ((LettuceConnectionFactory) this.redisTemplate.getConnectionFactory()).setDatabase(dbIndexEnum.getIndex());
            ((LettuceConnectionFactory) this.redisTemplate.getConnectionFactory()).resetConnection();

            redisTemplate.delete(key);
        } catch (Exception e) {
            logger.error("del e={}", e);
        }
    }
}
