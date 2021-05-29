package cn.edu.niit.mapper;

import cn.edu.niit.entity.ClassInfo;

import java.util.ArrayList;

/**
 * @ClassName ClassMapper
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/29
 **/
public interface ClassMapper {
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
     * 删除类别信息
     * @param cid
     * @return
     */
    int delBookType(Integer cid);

    /**
     * 新增类别信息
     * @param cname
     * @return
     */
    int addBookType(String cname);
}
