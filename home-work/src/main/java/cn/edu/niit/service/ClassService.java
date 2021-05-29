package cn.edu.niit.service;

import cn.edu.niit.entity.ClassInfo;

import java.util.ArrayList;

/**
 * @ClassName classService
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/29
 **/
public interface ClassService {

    /** 查询所有图书类别
     * @return
     */
    ArrayList<ClassInfo> listType() throws Exception;

    /**
     * 修改类别信息
     * @param classInfo
     * @return
     */
    int  updateBookType(ClassInfo classInfo);

    /**
     * 根据id删除书籍
     * @param bookId
     * @return
     */
    int delBook(int bookId);

    /**
     * 新增类别信息
     * @param cname
     * @return
     */
    int addBookType(String cname);
}
