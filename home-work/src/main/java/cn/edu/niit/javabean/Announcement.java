package cn.edu.niit.javabean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Announcement
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/29
 **/
@Data
@NoArgsConstructor
public class Announcement {
    private  String id;
    private String title;
    private  String detail;
    private String publish_date;

    public Announcement(String id, String title, String detail, String publish_date) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.publish_date = publish_date;
    }


}
