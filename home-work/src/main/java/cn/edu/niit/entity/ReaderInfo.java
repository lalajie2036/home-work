package cn.edu.niit.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReaderInfo {
    private Integer id;
    private Integer readerId;
    private String name;
    private Integer password;
    private String sex;
    private String birthday;
    private String address;
    private String telephone;
    private Integer cardState;

}