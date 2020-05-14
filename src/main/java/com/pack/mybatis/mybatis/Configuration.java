package com.pack.mybatis.mybatis;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * @version 1.0
 * @Author: 娃哈哈
 * @Description:
 * @Date: 2020/5/14 14:46
 */
public class Configuration {

    public static final ResourceBundle sqlMappings;
    public static final ResourceBundle dataSource;

    static {
        sqlMappings = ResourceBundle.getBundle("v1sql");
        dataSource = ResourceBundle.getBundle("jdbc");
        new DBConnection(dataSource);
    }

    public <T> T getMapper(Class clazz, SqlSession sqlSession) {
       return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new MapperProxy(sqlSession));
    }
}
