package com.example.springboot.dao;

import com.example.springboot.dao.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: chenglvpeng
 * @Date: 2019/1/15  14:13
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public interface UserMapper {

    List<User> listUser();

    int update(@Param("id") Long id, @Param("password") String password);
}
