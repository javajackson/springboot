package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/22  09:15
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Value("${fbapi.shop.url}")
    String url;

    @Override
    public String hello() {
        System.out.println(url);
        return url;
    }
}
