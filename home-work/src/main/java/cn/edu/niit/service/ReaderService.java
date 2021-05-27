package cn.edu.niit.service;

import cn.edu.niit.entity.ReaderInfo;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ReaderService
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/27
 **/
public interface ReaderService {
    /**
     * 查询用户信息登录
     * @param read
     * @return
     * @throws Exception
     */
    ReaderInfo select(ReaderInfo read) throws Exception;

    /**
     * 新增用户（注册）
     * @param readerInfo
     * @return
     */
    int addReade(ReaderInfo readerInfo);


    /**
     * 新增用户（管理员新增）
     * @param reader
     * @return
     */
    int addReader(ReaderInfo reader);

    /**
     * 得到用户列表
     * @param paramMap
     * @return
     */
    List<ReaderInfo> queryList(Map<String, Object> paramMap);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ReaderInfo selectById(Integer id);

    /**
     * 修改用户信息
     * @param readerInfo
     * @return
     */
    int updateReader(ReaderInfo readerInfo);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    int  delReader(Integer id);

    /**
     *修改密码
     * @param readerInfo
     * @return
     */
    int updpwd(ReaderInfo readerInfo);
}
