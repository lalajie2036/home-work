package cn.edu.niit.service.impl;
import cn.edu.niit.entity.ClassInfo;
import cn.edu.niit.mapper.ClassMapper;
import cn.edu.niit.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * @ClassName ClassServiceImpl
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/29
 **/
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;

    @Override
    public ArrayList<ClassInfo> listType() throws Exception{
        return classMapper.listType();
    }

    @Override
    public int updateBookType(ClassInfo classInfo) {
        int i = classMapper.updateBookType(classInfo);
        if (i>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
        return i;
    }

    @Override
    public int delBook(int bookId) {
        int i = classMapper.delBookType(bookId);
        if (i>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        return i;
    }

    @Override
    public int addBookType(String cname) {
        int i = classMapper.addBookType(cname);
        if (i>0){
            System.out.println("新增成功");
        }else {
            System.out.println("新增失败");
        }
        return i;
    }
}
