package cn.edu.niit.dao;

import cn.edu.niit.db.JDBCUtil;
import cn.edu.niit.javabean.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Mister-Lu
 */
public class LoginDao {

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
                        resultSet.getString("reader"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
