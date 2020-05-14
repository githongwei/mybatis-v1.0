package com.pack.mybatis.mapper;

import com.pack.mybatis.entity.Blog;

/**
 * @version 1.0
 * @Author: 娃哈哈
 * @Description:
 * @Date: 2020/5/14 14:43
 */
public interface BolgMapper {

    /**
     * 测试通过ID获取信息
     * @param bid
     * @return
     */
    Blog selectById(int bid);

}
