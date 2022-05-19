package com.test.service.impl;

import com.test.mapper.BrandMapper;
import com.test.pojo.Brand;
import com.test.service.BrandService;
import com.test.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        SqlSession session=sqlSessionFactory.openSession(true);
        BrandMapper mapper=session.getMapper(BrandMapper.class);
        List<Brand> brands=mapper.selectAll();
        session.close();
        return brands;

    }
}
