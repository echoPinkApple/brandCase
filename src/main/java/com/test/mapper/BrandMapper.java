/*
 * @Author: francis_xin francis_xin@foxmail.com
 * @Date: 2022-05-20 20:37:34
 * @LastEditors: francis_xin francis_xin@foxmail.com
 * @LastEditTime: 2022-05-20 22:09:57
 * @FilePath: /brandCase/src/main/java/com/test/mapper/BrandMapper.java
 * @Description: brand mapper
 * 
 * Copyright (c) 2022 by francis_xin francis_xin@foxmail.com, All Rights Reserved. 
 */
package com.test.mapper;

import com.test.pojo.Brand;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface BrandMapper {

    /**
     * @description: 
     * @return {List<Brand>}
     */    
    List<Brand> selectAll();
    List<Brand> selectOne(Brand brand);
    List<Brand> selectByCondition(Brand brand);
    int addBrand(Brand brand);
    List<Brand> selectByPage(@Param("begin")int begin,@Param("size")int size);
    @Select("select count(*) from tb_brand")
    int selectTotalCount();
}
