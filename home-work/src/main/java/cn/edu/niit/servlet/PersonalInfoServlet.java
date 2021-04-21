package cn.edu.niit.servlet;

import cn.edu.niit.javabean.User;
import cn.edu.niit.service.UserService;
import cn.edu.niit.util.ConString;
import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

/**
 * @ClassName PersonalInfoServlet
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/4/21
 **/
@WebServlet(name = "PersonalInfoServlet", urlPatterns = "/personal" + "/upload")
@MultipartConfig()
public class PersonalInfoServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        //1. 接收参数
        User user = new User(
                req.getParameter("username"),
                req.getParameter("nickname"),
                req.getParameter("sex"),
                req.getParameter("cellphone"),
                req.getParameter("email"),
                req.getParameter("remarks"));

        //从请求中取出文件
        Collection<Part> parts = req.getParts();
        //上传单个文件
        try {
            if (parts.size() > 1) {
                //Servlet3.0将multipart/form-data的POST请求封装成Part，通过Part
                // 对上传的文件进行操作。
                //Part part = parts[0];//从上传的文件集合中获取Part对象
                Part part = req.getPart("avatar");
                //获取文件名
                String fileName = part.getHeader("content-Disposition");
                //截取不同类型的文件（需自行判断）
                String[] fileNames = fileName.split("\\.");
                String uuid = UUID.randomUUID().toString();
                String file =
                        uuid + "." + fileNames[fileNames.length - 1];
                //把文件写到指定路径
                part.write(ConString.HEADER_FILE_DIR + file);
                user.setHeader("/header/" + file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String message = userService.uploadUserInfo(user, req.getSession());

        //resp.getWriter().print("<script>location.reload()" +
        //        "</script>");
        //转向会原页面，刷新页面
        req.getRequestDispatcher("/personalInfo.jsp?message=" + message).forward(req, resp);
    }
}

