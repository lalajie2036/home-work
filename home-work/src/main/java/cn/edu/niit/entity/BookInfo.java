package cn.edu.niit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName BookInfo
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/29
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInfo {
    private Integer bookId;
    private String name;
    private String author;
    private String publish;
    private String isbn;
    private String introduction;
    private String language;
    private Double price;
    private String pubdate;
    private Integer cid;
    private Integer stock;
}
