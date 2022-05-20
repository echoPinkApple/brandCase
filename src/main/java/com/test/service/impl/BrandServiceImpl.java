package com.test.service.impl;

import com.test.mapper.BrandMapper;
import com.test.pojo.Brand;
import com.test.pojo.PageBean;
import com.test.service.BrandService;
import com.test.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService
{

    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll()
    {
        SqlSession session=sqlSessionFactory.openSession();
        BrandMapper mapper=session.getMapper(BrandMapper.class);
        List<Brand> brands=mapper.selectAll();
        session.close();
        return brands;

    }
    @Override
    public List<Brand> selectByCondition(Brand brand)
    {
        SqlSession session=sqlSessionFactory.openSession();
        BrandMapper mapper=session.getMapper(BrandMapper.class);
        List<Brand> brands=mapper.selectByCondition(brand);
        session.close();
        return brands;
    }
    @Override
    public int addBrand(Brand brand)
    {
        SqlSession session=sqlSessionFactory.openSession();
        BrandMapper mapper=session.getMapper(BrandMapper.class);
        int flag=  mapper.addBrand(brand);
        session.commit();
        session.close();
        return flag;
    }

    @Override
    public List<Brand> selectOne(Brand brand)
    {
        SqlSession session=sqlSessionFactory.openSession();
        BrandMapper mapper=session.getMapper(BrandMapper.class);
        List<Brand> brand_return= mapper.selectOne(brand);
        session.close();
        return  brand_return;
    }
    @Override
    public PageBean<Brand> selectByPage(int currentPage,int pageSize)
    {
        SqlSession session=sqlSessionFactory.openSession();
        BrandMapper mapper=session.getMapper(BrandMapper.class);
        int begin=(currentPage-1)*pageSize;
        int size=pageSize;
        List<Brand> brands= mapper.selectByPage(begin, size);
        int totalCount=mapper.selectTotalCount();
        PageBean<Brand> pageBean=new PageBean<>();
        pageBean.settotalCount(totalCount);
        pageBean.setRows(brands);
        return pageBean;
    }
}
