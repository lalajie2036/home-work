package cn.edu.niit.servlet;

import cn.edu.niit.dao.BookDao;
import cn.edu.niit.javabean.Book;
import cn.edu.niit.javabean.User;
import cn.edu.niit.service.BookService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName SearchBorrowHistoryBookServlet
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/29
 **/
@WebServlet(name = "SearchBorrowHistoryBooksServlet" ,urlPatterns = "/borrowHistoryBooks")
public class SearchBorrowHistoryBookServlet extends HttpServlet {
    BookDao booksDao = new BookDao();
    BookService booksService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String paramJson = IOUtils.toString(req.getInputStream(), "UTF-8");
        HashMap<String, Object> parseObject = JSON.parseObject(paramJson, HashMap.class);
        String param = (String) parseObject.get("search");


        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String userId  = user.getId();

        int pageNum = (int) parseObject.get("pageNum");
        int pageSize = (int) parseObject.get("pageSize");
        List<Book> historyBooks = new ArrayList<>();
        int count = 0 ;

        if (param != null){

        }else {
            historyBooks = booksService.selectBorrowHistoryBooks(pageNum, pageSize, userId);
        }
        count = booksService.countBorrowHistoryNum(userId);

        //3. 将结果放入session
        req.getSession().setAttribute("historyBooks", historyBooks);
        //将count直接作为ajax请求的结果返回
        resp.getWriter().print(count);
    }

}

