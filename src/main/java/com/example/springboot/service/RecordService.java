package com.example.springboot.service;

import com.example.springboot.dao.domain.Record;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/14  19:57
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public interface RecordService {
    int insert(Record record);
}
