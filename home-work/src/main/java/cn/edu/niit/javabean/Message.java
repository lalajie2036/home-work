package cn.edu.niit.javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Message
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/30
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Message {
    private String id;
    private String detail;
    private String cardId;
    private  String publicDate;
}
