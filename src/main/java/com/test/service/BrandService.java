package com.test.service;

import com.test.pojo.Brand;
import com.test.pojo.PageBean;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();
    List<Brand> selectByCondition(Brand brand);
    int addBrand(Brand brand);
    List<Brand> selectOne(Brand brand);
    public PageBean<Brand> selectByPage(int currentPage,int size);
}
