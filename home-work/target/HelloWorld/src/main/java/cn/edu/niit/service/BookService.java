package cn.edu.niit.service;

import cn.edu.niit.dao.BookDao;
import cn.edu.niit.javabean.Book;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName BookService
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/4/21
 **/
public class BookService {
    private final BookDao bookDao = new BookDao();

    public List<Book> searchAllBooks(String username, int pageNum, int pageSize) throws SQLException {
        List<Book> books = bookDao.selectAll(pageNum, pageSize);
        for (Book book : books) {
            book.setStore(isStore(username, book.getId()));
        }
        return books;
    }

    public int countNum() {
        return bookDao.count();
    }

    public boolean isStore(String username, String bookId) {
        return bookDao.selectStore(username, bookId);
    }

    public String storeBook(String username, String bookId) {
        int result = bookDao.insertStoreBook(username, bookId);
        if (result > 0) {
            return "借阅成功";
        } else {
            return "借阅失败";
        }
    }
}

