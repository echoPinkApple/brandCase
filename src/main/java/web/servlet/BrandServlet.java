package web.servlet;

import com.alibaba.fastjson.JSON;
import com.test.pojo.Brand;
import com.test.service.BrandService;
import com.test.service.impl.BrandServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet
{
    private final BrandService brandService=new BrandServiceImpl();
    public void  selectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        List<Brand> brands=brandService.selectAll();
        String jsonString= JSON.toJSONString(brands);
        System.out.println(jsonString);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }


    public  void selectOne(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        request.setCharacterEncoding("UTF-8");
        String brandStr=request.getReader().readLine();
        Brand brand=JSON.parseObject(brandStr,Brand.class);
        List<Brand> brands=brandService.selectOne(brand);
    }


    public  void selectByCondition(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        request.setCharacterEncoding("UTF-8");
        String brandStr=request.getReader().readLine();
        //System.out.println(brandStr);
        Brand brand=JSON.parseObject(brandStr,Brand.class);
        List<Brand> brands=brandService.selectByCondition(brand);
        String resultBrandsString= JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(resultBrandsString);
    }

    public void addBrand(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        request.setCharacterEncoding("UTF-8");
        String brandStr=request.getReader().readLine();
        Brand brand=JSON.parseObject(brandStr,Brand.class);
        int flag=brandService.addBrand(brand);
        response.setContentType("text/json;charset=utf-8");
        if(flag>=1)
        {
            response.getWriter().write("success");
        }
        else
        {
            response.getWriter().write("unsuccessful");
        }
    }
}
