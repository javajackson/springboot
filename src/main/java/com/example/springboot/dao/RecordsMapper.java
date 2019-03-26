package com.example.springboot.dao;

import com.example.springboot.dao.domain.Record;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/14  19:52
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public interface RecordsMapper {
    int insert(Record record);
}
