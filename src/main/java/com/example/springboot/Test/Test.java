package com.example.springboot.Test;

import java.sql.*;

/**
 * @Author: chenglvpeng
 * @Date: 2019/2/18  17:10
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Test {
    public void test() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8";
            connection = DriverManager.getConnection(url,"root", "root");
            String sql = "select user_name from af_user";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String userName = rs.getString(1);
                System.out.println(userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != connection) {
                    connection.close();
                }
                if (null != rs) {
                    rs.close();
                }
                if (null != ps) {
                    ps.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }
}
