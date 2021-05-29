package cn.edu.niit.javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mister-Lu
 */
@Data
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private String password;
    private String reader;
    private String header;
    private String cellphone;
    private String email;
    private String describe;
    private boolean sex;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String describe) {
        this.username = username;
        this.password = password;
        this.describe = describe;
    }
    public User(String username, String nickname, String sex,
                String cellphone,
                String email, String remarks) {
        this.username = username;
        this.reader = nickname;
        if("男".equals(sex)) {
            this.sex = true;
        } else {
            this.sex = false;
        }
        this.cellphone = cellphone;
        this.email = email;
        this.describe = remarks;
    }

    public User(String id, String username, String reader, String header, String cellPhone, String describe, String email, boolean sex) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.reader = reader;
        this.header = header;
        this.cellphone = cellPhone;
        this.sex = sex;
        this.email = email;
        this.describe = describe;
    }
}