package com.example.springboot.controller;

import com.example.springboot.dao.domain.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: chenglvpeng
 * @Date: 2019/1/15  14:30
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/listUser")
    public String listUser(){
        List<User> list = userService.listUser();
        return list.toString();
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        String password = request.getParameter("password");
        int result = userService.update(id, password);
        if (result > 0) {
            return "update success!";
        } else {
            return "update fail";
        }
    }
}
