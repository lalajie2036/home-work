package cn.edu.niit.servlet;

import cn.edu.niit.javabean.Book;
import cn.edu.niit.service.BookService;
import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName SearchBooksServlet
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/4/12
 **/
@WebServlet(name = "SearchBooksServlet", urlPatterns = "/book/search")
public class SearchBooksServlet extends HttpServlet {

    private final BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 取参（req当前的页码, 每页的数量, 搜索）
        String paramJson = IOUtils.toString(req.getInputStream(), StandardCharsets.UTF_8);
        HashMap parseObject = JSON.parseObject(paramJson, HashMap.class);
        String param = (String) parseObject.get("search");
        int pageNum = (int) parseObject.get("pageNum");
        int pageSize = (int) parseObject.get("pageSize");
        List<Book> books = new ArrayList<>();
        int count = 0;
        //2.
        if (param != null) {
            //带参数查询
        } else {
            //无参查询
            books = bookService.searchAllBooks((String) req.getSession().getAttribute("id"), pageNum, pageSize);
        }

        count = bookService.countNum();

        //3. 将结果放入session
        req.getSession().setAttribute("books", books);
        //将count直接作为ajax请求的结果返回
        resp.getWriter().print(count);
    }
}

