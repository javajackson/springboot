package com.example.springboot.service.impl;

import com.example.springboot.dao.RecordsMapper;
import com.example.springboot.dao.domain.Record;
import com.example.springboot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/14  19:57
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Service("recordService")
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordsMapper recordsMapper;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(Record record) {
         return recordsMapper.insert(record);
    }
}
