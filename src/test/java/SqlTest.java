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
        BrandMapper mapper;
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            mapper = sqlSession.getMapper(BrandMapper.class);
        }
        List<Brand> brands=mapper.selectAll();
        System.out.println(brands);
    }
    @Test
    public void BrandServiceTest()
    {
        BrandService service=new BrandServiceImpl();
        List<Brand> brands= service.selectAll();
        System.out.println(brands);
    }
}
