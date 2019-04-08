package com.example.springboot.Test.test;

import com.example.springboot.common.enumeration.RedisExpireEnum;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: chenglvpeng
 * @Date: 2019/4/1  14:36
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Test5 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("com.example.springboot.common.enumeration.RedisExpireEnum");
//        Constructor<?> constructor = clazz.getDeclaredConstructor(Long.class, String.class);
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Constructor<?> constructor = constructors[0];
        constructor.setAccessible(true);
        RedisExpireEnum redisExpireEnum = (RedisExpireEnum)constructor.newInstance(10L,"aaaa");


        System.out.println(redisExpireEnum.getSeconds() + " " + redisExpireEnum.getDesc());
    }
}
