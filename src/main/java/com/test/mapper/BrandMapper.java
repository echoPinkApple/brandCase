package com.test.mapper;

import com.test.pojo.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll();
}
