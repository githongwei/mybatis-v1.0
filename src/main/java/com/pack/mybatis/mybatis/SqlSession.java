package com.pack.mybatis.mybatis;

/**
 * @version 1.0
 * @Author: 娃哈哈
 * @Description:
 * @Date: 2020/5/14 14:49
 */
public class SqlSession {

    private Configuration configuration;

    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor){
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String statementId, Object paramater){
        // 根据statementId拿到SQL
        String sql = Configuration.sqlMappings.getString(statementId);
        if(null != sql && !"".equals(sql)){
            return executor.query(sql, paramater );
        }
        return null;
    }

    public <T> T getMapper(Class clazz){
        return configuration.getMapper(clazz, this);
    }

}
