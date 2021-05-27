package cn.edu.niit.util;

/**
 * @ClassName SuccessUtil
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/26
 **/
//是否成功及成功信息的工具定义类
public class SuccessUtil {
    private boolean success;    //是否成功
    private String message;    //是否成功的信息
    private String status;    //是否成功的状态码   1为成功，2为用户名或密码错误，3为其他错误

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
