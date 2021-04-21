package cn.edu.niit.javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Book
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/4/19
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String id;
    private String name;
    private String author;
    private String sort;
    private String description;
    private boolean store;


    public Book(String id, String name, String author, String sort, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.sort = sort;
        this.description = description;
    }
}