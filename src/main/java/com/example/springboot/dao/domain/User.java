package com.example.springboot.dao.domain;

import lombok.Data;

/**
 * @Author: chenglvpeng
 * @Date: 2019/1/15  14:20
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
}
