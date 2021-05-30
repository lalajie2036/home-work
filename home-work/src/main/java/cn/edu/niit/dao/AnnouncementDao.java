package cn.edu.niit.dao;

import cn.edu.niit.db.JDBCUtil;
import cn.edu.niit.javabean.Announcement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AnnouncementDao
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/29
 **/
public class AnnouncementDao {
    public List<Announcement> selectAll(int pageNum, int pageSize ) {

        String sql = "select * from announcement limit ?,?";
        List<Announcement> announcements = new ArrayList<>();
        try(ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql,
                new Object[]{(pageNum - 1) * pageSize, pageSize})){
            while (rs.next()){
                Announcement announcement = new Announcement(
                        rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("detail"),
                        rs.getString("publish_date"));

                announcements.add(announcement);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return announcements;
    }
    public  int countAnnouncement(){
        String sql = "select count(*) as countNum from announcement  ";
        try (ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql, new Object[]{})){
            while (rs.next()){
                int count  = rs.getInt("countNum");

                return count;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
