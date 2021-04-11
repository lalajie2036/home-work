package cn.edu.niit.dao;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/4/11
 **/
import cn.edu.niit.db.JDBCUtil;
import cn.edu.niit.javabean.Admin;
import cn.edu.niit.javabean.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User selectOne(String username) {
        User user = null;
        try (ResultSet resultSet =
                     JDBCUtil.getInstance().executeQueryRS("select " +
                                     "* " +
                                     "from " +
                                     "borrow_card where username=?",
                             new Object[]{username})) {

            while (resultSet.next()) {
                user = new User(resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("reader"),
                        resultSet.getString("header"),
                        resultSet.getString("cellphone"),
                        resultSet.getString("email"),
                        resultSet.getString("describe"),
                        resultSet.getBoolean("sex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public Admin selectOne(String username, String password) {
        Admin admin = null;
        try (ResultSet resultSet =
                     JDBCUtil.getInstance().executeQueryRS("select " +
                                     "* " +
                                     "from " +
                                     "admin where username=?",
                             new Object[]{username})) {

            while (resultSet.next()) {
                admin = new Admin(resultSet.getString("username"),
                        resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }

    public int addUser(User register) {
        String sql = "INSERT IGNORE INTO `borrow_card` (username," +
                "`password`, reader) \n" +
                "SELECT ?,?,? WHERE NOT EXISTS (\n" +
                "SELECT 1 FROM borrow_card WHERE `username`=?);";
        return JDBCUtil.getInstance().executeUpdate(sql,
                new Object[]{register.getUsername(),
                        register.getPassword(),
                        register.getReader(),
                        register.getUsername()});
    }
}