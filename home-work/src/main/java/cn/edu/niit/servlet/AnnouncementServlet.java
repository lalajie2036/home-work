package cn.edu.niit.servlet;

import cn.edu.niit.javabean.Announcement;
import cn.edu.niit.service.AnnouncementService;
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
 * @ClassName AnnouncementServlet
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/29
 **/
@WebServlet(name = "AnnouncementServlet" , urlPatterns = "/search/notification")
public class AnnouncementServlet extends HttpServlet {


    private AnnouncementService announcementService = new AnnouncementService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramJson = IOUtils.toString(req.getInputStream(), "UTF-8");
        HashMap<String, Object> parseObject = JSON.parseObject(paramJson, HashMap.class);
        String param = (String) parseObject.get("search");

        int pageNum = (int) parseObject.get("pageNum");
        int pageSize = (int) parseObject.get("pageSize");

        List<Announcement> announcements = new ArrayList<>();
        int count = 0;

        if (param != null){
            //带参数查询
        }else {
            announcements = announcementService.searchAllAnnouncement(pageNum, pageSize);
        }
        count = announcementService.searchAnnouncement();
        //将结果放入session
        req.getSession().setAttribute("announcements",announcements);
        //将count直接作为ajax请求的结果返回
        resp.getWriter().print(count);
    }


}
