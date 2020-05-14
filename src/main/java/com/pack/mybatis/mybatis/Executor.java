package com.pack.mybatis.mybatis;

import com.pack.mybatis.entity.Blog;

import java.sql.*;

/**
 * @version 1.0
 * @Author: 娃哈哈
 * @Description:
 * @Date: 2020/5/14 15:32
 */
public class Executor {

    public <T> T query(String sql, Object paramater) {
        Connection connection = DBConnection.getConnection();
        Statement stmt = null;
        Blog blog = new Blog();
        try {
            // 执行查询
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(String.format(sql, paramater));
            // 获取结果集
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }
            System.out.println(blog);
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return (T)blog;
    }

}
