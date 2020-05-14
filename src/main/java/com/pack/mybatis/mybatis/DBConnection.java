package com.pack.mybatis.mybatis;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @version 1.0
 * @Author: 娃哈哈
 * @Description:
 * @Date: 2020/5/14 15:02
 */
public class DBConnection {

    public static ResourceBundle dataSource;

    public DBConnection(ResourceBundle dataSource) {
        DBConnection.dataSource = dataSource;
    }

    public static Connection getConnection(){
        String driver = dataSource.getString("jdbc.driver");
        String url = dataSource.getString("jdbc.url");
        String username = dataSource.getString("jdbc.username");
        String password = dataSource.getString("jdbc.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn  = java.sql.DriverManager.getConnection(url,username,password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
