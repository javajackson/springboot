package com.example.springboot.dao.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/14  19:53
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Data
public class Record {
    private Long id;
    private Long orderId;
    private Date gmtPaid;
}
