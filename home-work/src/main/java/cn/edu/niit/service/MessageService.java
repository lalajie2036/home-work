package cn.edu.niit.service;

import cn.edu.niit.dao.MessageDao;
import cn.edu.niit.javabean.Message;

import java.util.List;

/**
 * @ClassName MessageService
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/30
 **/
public class MessageService {
    private MessageDao messageDao = new MessageDao();

    public List<Message> searchAllMessage(int pageNum, int pageSize){
        List<Message> messages = messageDao.SelectAll(pageNum, pageSize);
        return  messages;
    }

    public int  searchMessage(){
        return  messageDao.countMessage();
    }
}
