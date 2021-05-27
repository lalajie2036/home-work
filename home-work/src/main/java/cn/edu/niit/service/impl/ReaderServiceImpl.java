package cn.edu.niit.service.impl;

import cn.edu.niit.entity.ReaderInfo;
import cn.edu.niit.mapper.ReaderMapper;
import cn.edu.niit.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ReaderServiceImpl
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/27
 **/
@Service("ReaderService")
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderMapper readerMapper;

    @Override
    public ReaderInfo select(ReaderInfo read) throws Exception {
        return readerMapper.select(read);
    }

    @Override
    public int addReade(ReaderInfo readerInfo) {
        int i = readerMapper.addReade(readerInfo);
        if (i>0){
            System.out.println("新增成功");
        }else {
            System.out.println("新增失败");
        }
        return i;
    }

    @Override
    public int addReader(ReaderInfo reader) {
        int i = readerMapper.addReader(reader);
        if (i>0){
            System.out.println("新增成功");
        }else {
            System.out.println("新增失败");
        }
        return i;
    }

    @Override
    public List<ReaderInfo> queryList(Map<String, Object> paramMap) {
        //执行查询
        List<ReaderInfo> readerInfo = readerMapper.queryList(paramMap);
        return readerInfo;
    }

    @Override
    public ReaderInfo selectById(Integer id) {
        return readerMapper.selectById(id);
    }

    @Override
    public int updateReader(ReaderInfo readerInfo) {
        return readerMapper.updateReader(readerInfo);
    }

    @Override
    public int delReader(Integer id) {
        return readerMapper.delReader(id);
    }

    @Override
    public int updpwd(ReaderInfo readerInfo) {
        int i = readerMapper.updpwd(readerInfo);
        if (i>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
        return i;
    }


}
