package cn.edu.niit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName UserLoginOut
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/26
 **/
@WebServlet("/logOut")
public class UserLoginOut extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        if(session.getAttribute(username) != null) {
            session.removeAttribute(username);
        }
        resp.sendRedirect(req.getContextPath() +"/index.jsp");
    }

}
