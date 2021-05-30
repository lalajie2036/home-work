package cn.edu.niit.javabean;

import cn.edu.niit.util.Base;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mister-Lu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private String username;
    private String password;

    public Map getBookList(String page, String limit, Map where) throws ClassNotFoundException, SQLException {
        Map<String, Object> map = new HashMap<String, Object>();
        String whereString = "";
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        connection = Base.getConnection();
        int number = Integer.valueOf(page);
        int size = Integer.valueOf(limit);
        String sql = "select * from books ";
        if(where!=null && !where.isEmpty()) {
            whereString += " where "+where.get("condition") +" like '%" +where.get("conditionValue") +"%' ";
            sql += whereString;
        }
        sql += "order by id desc  ?,? ";
        pstmt = (PreparedStatement) connection.prepareStatement(sql);
        pstmt.setInt(1, (number-1) * size );
        pstmt.setInt(2, size);

        resultSet = pstmt.executeQuery();
        JSONObject json = new JSONObject();
        String result = "";
        int i = 1;

        // 获取行数据
        while( resultSet.next() ) {
            //System.out.println("????-------" +resultSet.getInt("count"));
            json.put("id", resultSet.getInt("id"));
            json.put("name", resultSet.getString("name"));
            json.put("author", resultSet.getString("author"));
            json.put("library_id", resultSet.getInt("library_id"));
            json.put("sort_id", resultSet.getInt("sort_id"));
            json.put("position", resultSet.getString("position"));
            json.put("status", resultSet.getInt("status"));
            json.put("description", resultSet.getString("description"));
            if(i==1) {
                result = json.toString();
            }else {
                result += "," +json.toString();
            }
            i++;
        }
        map.put("data", result);

        // 获取总数count，重写sql
        int count = 0;
        sql = "select count(*) as count  from books ";
        if(where!=null && !where.isEmpty()) {
            sql += whereString;
        }
        pstmt = connection.prepareStatement(sql);
        resultSet = pstmt.executeQuery();
        if(resultSet.next()) {
            count = resultSet.getInt("count");
        }
        map.put("count", count);
        Base.closeResource(connection, pstmt, resultSet);
        return map;

    }

}
