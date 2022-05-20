import com.test.mapper.BrandMapper;
import com.test.pojo.Brand;
import com.test.service.BrandService;
import com.test.service.impl.BrandServiceImpl;
import com.test.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class SqlTest {

    @Test
    public void SqlSessionConnectionTest()
    {
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
       
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper  mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands=mapper.selectAll();
        sqlSession.close();
        System.out.println(brands);
    }
    @Test
    public void BrandServiceTest()
    {
        BrandService service=new BrandServiceImpl();
        List<Brand> brands= service.selectAll();
        System.out.println(brands);
    }

    @Test
    public void SelectByConditionTest()
    {
        Brand brand=new Brand(1,"小米","小米","10","test",1);
        SqlSessionFactory sessionFactory=SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession session=sessionFactory.openSession();
        BrandMapper mapper=session.getMapper(BrandMapper.class);
        List<Brand> lists=mapper.selectByCondition(brand);
        session.close();
        System.out.println(lists);
    }
    @Test
    public void addBrand()
    {
        Brand brand=new Brand(1 ,"小米","小米科技","10","mapper addBrand test",1);
        SqlSessionFactory sessionFactory=SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession session=sessionFactory.openSession();
        BrandMapper mapper= session.getMapper(BrandMapper.class);

        int flag=mapper.addBrand(brand);
        session.commit();
        System.out.println(flag);
        session.close();
    }

    @Test
    public void selectOneTest()
    {
        Brand brand=new Brand(1 ,"小米","小米科技","10","mapper addBrand test",1);
        SqlSessionFactory sessionFactory=SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession session=sessionFactory.openSession();
        BrandMapper mapper= session.getMapper(BrandMapper.class);

        List<Brand> brand1=mapper.selectOne(brand);
        //session.commit();
        System.out.println(brand1);
        session.close();
    }
}
