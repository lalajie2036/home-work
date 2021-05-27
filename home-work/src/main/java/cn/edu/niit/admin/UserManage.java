package cn.edu.niit.admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;

import cn.edu.niit.dao.UserDao;
import cn.edu.niit.javabean.User;
import cn.edu.niit.util.Base;
import cn.edu.niit.util.Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @ClassName UserList
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/25
 **/
@WebServlet("/admin/managerList")
public class UserManage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");
        // 准备数据
        Connection connection = null;
        PreparedStatement pstmt = null;
        String sql = "";
        ResultSet resultSet = null;
        // 返回数据
        int code = 1;
        String msg = "error";
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        PrintWriter out = resp.getWriter();
        try {
            connection = (Connection) Base.getConnection();
            sql = "select * from manager";
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                jsonObject.put("id", resultSet.getString("id"));
                jsonObject.put("name", resultSet.getString("name"));
                jsonObject.put("account", resultSet.getString("account"));
                jsonObject.put("password", resultSet.getString("password"));
                jsonObject.put("email", resultSet.getString("email"));
                jsonArray.add(jsonObject);
            }
            if (!jsonArray.isEmpty()) {
                code = 0;
                msg = "查询成功";
            } else {
                msg = "数据为空";
            }
        } catch (ClassNotFoundException e) {
            msg = "class找不到";
        } catch (SQLException e) {
            msg = "sql错误";
        }
        out.print(Util.jsonResponse(code, msg, jsonArray.toString()));
    }

}
