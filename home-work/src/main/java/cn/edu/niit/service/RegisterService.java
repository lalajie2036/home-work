package cn.edu.niit.service;

import cn.edu.niit.dao.LoginDao;
import cn.edu.niit.dao.RegisterDao;
import cn.edu.niit.javabean.User;

import java.sql.SQLException;


/**
 * @author Mister-Lu
 */
public class RegisterService {
    private final RegisterDao registerDao = new RegisterDao();
    LoginDao loginDao = new LoginDao();

    public String  register(User register) throws SQLException {
            String result=String.valueOf(registerDao.register(register));

         if ("0".equals(result)){
            return "注册失败";
        }else {
             return "注册成功";
            }
        }

    }



