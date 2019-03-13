package com.example.springboot.service.impl;

import com.example.springboot.dao.UserMapper;
import com.example.springboot.dao.domain.User;
import com.example.springboot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = Exception.class)
    public int update(Long id, String password) {

        try {
            int i = userMapper.update(id, password);

            List<User> list = userMapper.listUser();
            int j = 0;
            if (i > 0) {
                j = userMapper.update(id, password + 1);
                list = userMapper.listUser();
            int k = 5/0;
            } else {
                return 0;
            }

            if (j > 0){
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public int insert(String username, String password) {
        return userMapper.insert(username, password);
    }


}
