package com.pack.mybatis;

import com.pack.mybatis.entity.Blog;
import com.pack.mybatis.mapper.BolgMapper;
import com.pack.mybatis.mybatis.Configuration;
import com.pack.mybatis.mybatis.Executor;
import com.pack.mybatis.mybatis.SqlSession;

/**
 * @version 1.0
 * @Author: 娃哈哈
 * @Description:
 * @Date: 2020/5/14 15:53
 */
public class TestMybatis {

    public static void main(String[] args) {

        SqlSession sqlSession = new SqlSession(new Configuration(),new Executor());
        BolgMapper bolgMapper = sqlSession.getMapper(BolgMapper.class);
        bolgMapper.selectById(1);
    }

}
