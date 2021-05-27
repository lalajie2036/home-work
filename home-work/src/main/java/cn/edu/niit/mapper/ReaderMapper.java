package cn.edu.niit.mapper;
import cn.edu.niit.entity.ReaderInfo;

import java.util.List;
import java.util.Map;

public interface ReaderMapper {
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
     * 因为有个成功信息工具类，因为不需要返回值
     */
    int addReader(ReaderInfo reader);

    /**
     * 判断是否存在该用户
     * @param reader_id
     * @return
     */
    int checkReader(Integer reader_id);

    /**
     * 得到用户列表
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
