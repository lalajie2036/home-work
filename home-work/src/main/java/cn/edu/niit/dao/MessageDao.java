package cn.edu.niit.dao;

import cn.edu.niit.db.JDBCUtil;
import cn.edu.niit.javabean.Message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MessageDao
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/30
 **/
public class MessageDao {
    public List<Message> SelectAll(int pageNum, int pageSize){
        String sql = "select * from message limit ?,?";
        List<Message> messages = new ArrayList<>();
        try (ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql, new Object[]{(pageNum - 1) * pageSize, pageSize})){
            while (rs.next()){
                Message message = new Message(
                        rs.getString("id"),
                        rs.getString("detail"),
                        rs.getString("card_id"),
                        rs.getString("public_date"));

                messages.add(message);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return messages;
    }

    public  int countMessage(){
        String sql ="SELECT count(*) as mseNum FROM message";
        try (ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql, new Object[]{})){
            while (rs.next()){
                int count  = rs.getInt("mseNum");

                return count;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
