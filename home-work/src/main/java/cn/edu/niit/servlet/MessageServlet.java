package cn.edu.niit.servlet;

import cn.edu.niit.dao.MessageDao;
import cn.edu.niit.javabean.Message;
import cn.edu.niit.service.MessageService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName MessageServlet
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/30
 **/
@WebServlet(name = "MessageServlet", urlPatterns = "/search/message")
public class MessageServlet extends HttpServlet {
    MessageDao messageDao = new MessageDao();
    MessageService messageService = new MessageService();
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

        int pageNum = (int) parseObject.get("pageNum");
        int pageSize = (int) parseObject.get("pageSize");
        List<Message> messages = new ArrayList<>();
        int count  = 0;
        if (param != null){
            //带参数查询

        }else {
            messages = messageService.searchAllMessage(pageNum, pageSize);
        }
        count = messageService.searchMessage();
        //将结果放入session
        req.getSession().setAttribute("messages",messages);
        //将count直接作为ajax请求的结果返回
        resp.getWriter().print(count);
    }
}

