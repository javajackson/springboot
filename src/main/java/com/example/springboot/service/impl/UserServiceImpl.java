package com.example.springboot.service.impl;

import com.example.springboot.dao.UserMapper;
import com.example.springboot.dao.domain.User;
import com.example.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: chenglvpeng
 * @Date: 2019/1/15  14:29
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }
}
