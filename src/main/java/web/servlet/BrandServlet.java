package web.servlet;

import com.alibaba.fastjson.JSON;
import com.test.pojo.Brand;
import com.test.service.BrandService;
import com.test.service.impl.BrandServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private final BrandService brandService=new BrandServiceImpl();
    public void  selectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Brand> brands=brandService.selectAll();
        String jsonString= JSON.toJSONString(brands);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
