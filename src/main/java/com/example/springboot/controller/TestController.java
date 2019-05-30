package com.example.springboot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.dao.domain.CommonQuery;
import com.example.springboot.dao.domain.Person;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: chenglvpeng
 * @Date: 2019/4/11  13:32
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/hello",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object hello5(@RequestBody String query) {
        List<Person> personList = null;
        if (!StringUtils.isNotBlank(query)) {
            JSONObject object = JSONObject.parseObject(query);
            JSONArray array = object.getJSONArray("personList");
            personList = array.toJavaList(Person.class);
         }

        System.out.println(personList);
        Map<String, Object> data = new HashMap<>();
        data.put("personList" , personList);
        return data;
    }

    @RequestMapping(value = "/uploadGoodsId")
    public String uploadGoodsId(@RequestParam("filename") MultipartFile file) {
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        MultipartFile file = multipartRequest.getFile("filename");
        boolean flag = checkFileSuffix(file.getOriginalFilename());
        String curProjectPath = "/home/aladin/project/tomcat/orderUpload/";
        String fileName = curProjectPath + System.currentTimeMillis() + "_" + file.getOriginalFilename();
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(fileName));
            List<Long> goodsIdList = parseExcel(fileName);
            List<Long> newGoodsIdList = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "";
    }

    public List<Long> parseExcel(String fileName) throws IOException {
        List<Long> goodsIdList = new ArrayList<Long>();
        InputStream is = new FileInputStream(fileName);
        Sheet st = null;
        String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if ("xls".equalsIgnoreCase(fileSuffix)) {

            st = (new HSSFWorkbook(is)).getSheetAt(0);
        } else if ("xlsx".equalsIgnoreCase(fileSuffix)) {
            st = (new XSSFWorkbook(is)).getSheetAt(0);
        }
        //跳过表头
        for (int j = 1; j < st.getLastRowNum() + 1; j++) {
            // 创建一个行对象
            Row row = st.getRow(j);
            if (row != null) {
                Cell cell = row.getCell(Cell.CELL_TYPE_NUMERIC);
                Long value = new Double(cell.getNumericCellValue()).longValue();
                goodsIdList.add(value);
            }
        }
        return goodsIdList;
    }


    private boolean checkFileSuffix(String fileName) {
        if (StringUtils.isBlank(fileName) || fileName.indexOf(".") < 0) {
            return false;
        }
        String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if ("xls".equalsIgnoreCase(fileSuffix) || "xlsx".equalsIgnoreCase(fileSuffix)) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/test2")
    public String test2(@RequestBody CommonQuery query) {
        if (null == query.getC()) {
            return "c is null";
        } else {
            return query.getC();
        }
    }
}
