package com.example.springboot.service.redis;

import com.example.springboot.common.enumeration.RedisExpireEnum;
import com.example.springboot.common.enumeration.RedisIndexEnum;

import java.util.Map;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/14  14:47
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public interface IRedisCache {
    /**
     * 操作 redis的hash数据结构,存放在java中构建好的hashMap
     * @param dbIndexEnum redis的仓库  0-15 共16个仓库，请注意，存数据和取数据要选择一致的index
     * @param key 整个hash的名
     * @param hashMap java中形成的key，value键值对
     * @param seconds key 失效时间 单位：秒,null代表永久保存
     */
    Long hSetAll(RedisIndexEnum dbIndexEnum, String key, Map<String, Object> hashMap, RedisExpireEnum seconds);

    /**
     * 操作redis的hash数据结构, 获取某个key的整个hashMap值
     * @param dbIndexEnum redis的仓库  0-15 共16个仓库，请注意，存数据和取数据要选择一致的index
     * @param key 整个hash的名
     * @return 整个hash值
     *
     */
    Map<Object, Object> hGetAll(RedisIndexEnum dbIndexEnum, String key);

    /**
     * 删除key
     * @param dbIndexEnum redis的仓库  0-15 共16个仓库，请注意，存数据和取数据要选择一致的index
     * @param key 需要被删除的key
     */
    void del(RedisIndexEnum dbIndexEnum, String key);
}
