package com.test.service;

import com.test.pojo.Brand;
import java.util.List;

public interface BrandService {
    List<Brand> selectAll();
    List<Brand> selectByCondition(Brand brand);
}
