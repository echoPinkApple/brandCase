package com.test.mapper;

import com.test.pojo.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll();
    List<Brand> selectOne(Brand brand);
    List<Brand> selectByCondition(Brand brand);
    int addBrand(Brand brand);

}
