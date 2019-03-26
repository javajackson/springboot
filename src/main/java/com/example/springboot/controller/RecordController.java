package com.example.springboot.controller;

import com.example.springboot.dao.domain.Record;
import com.example.springboot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/14  19:59
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @RequestMapping("/pay")
    @Transactional(rollbackFor = Exception.class)
    public String add(Record record) {
        int result = recordService.insert(record);
       throw new RuntimeException();

    }
}
