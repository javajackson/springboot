package com.example.springboot.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import java.util.List;
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

    @Autowired
    private RedisTemplate redisTemplate;

    public void setKey(String key, String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key, value, 1, TimeUnit.MINUTES);
    }

    public String getValue(String key){
        ValueOperations<String, String> ops = template.opsForValue();
        return ops.get(key);
    }

    public <T> void listPushAll( String key, List<T> value, Long seconds) {
        if (null != key && !CollectionUtils.isEmpty(value)) {

            this.redisTemplate.opsForList().rightPushAll(key, value);
            this.redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
            /*try {



//                this.redisTemplate.exec();
            } catch (Exception var6) {
//                logger.error("listPushAll e:{}", var6);
            }*/

        }
    }

    public <T> List<T> listGetAll(String key) {
//        logger.info("dbIndexEnum : " + dbIndexEnum);
//        logger.info("key : " + key);
        if (null != key) {
            try {
//                ((LettuceConnectionFactory)this.redisTemplate.getConnectionFactory()).setDatabase(dbIndexEnum.getIndex());
//                ((LettuceConnectionFactory)this.redisTemplate.getConnectionFactory()).resetConnection();
                List<T> list = this.redisTemplate.opsForList().range(key, 0L, -1L);
//                logger.info("list :" + list);
                if (null != list && list.size() > 0) {
//                    logger.info("list is not empty :" + list.size());
                    return list;
                }
            } catch (Exception var4) {
//                logger.error("listGetAll e:{}", var4);
            }

            return null;
        } else {
//            logger.info("redisCacheSwitch or key is null");
            return null;
        }
    }

}
