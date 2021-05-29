package cn.edu.niit.dao;

import cn.edu.niit.db.JDBCUtil;
import cn.edu.niit.javabean.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 * @ClassName BookDao
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/4/19
 **/
public class
BookDao {
    public List<Book> selectAll(int pageNum, int pageSize) throws SQLException{
        String sql = "select books.*, book_sort.name as sort from books, book_sort where books.sort_id=book_sort.id limit ?,? ";

        List<Book> books = new ArrayList<>();
        try (ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql, new Object[]{(pageNum - 1) * pageSize, pageSize})) {
            while (rs.next()) {
                Book book = new Book(rs.getInt("id") + "",
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getString("sort"),
                        rs.getString("description"));
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public int count() {
        String sql = "select count(*) as countNum from books";
        try (ResultSet rs =
                     JDBCUtil.getInstance().executeQueryRS(sql,
                             new Object[]{})) {

            while (rs.next()) {
                int count = rs.getInt("countNum");
                return count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean selectStore(String username, String bookId) {
        String sql1 = "select EXISTS( SELECT 1 from borrow_books " +
                "where book_id=? and card_id=?) as store";
        try (ResultSet rs =
                     JDBCUtil.getInstance().executeQueryRS(sql1,
                             new Object[]{
                                     bookId, username
                             });) {

            while (rs.next()) {
                return rs.getBoolean("store");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int insertStoreBook(String username, String bookId) {
        String sql = "insert into borrow_books(book_id, card_id, " +
                "borrow_date) values(?,?,?)";
        int result = JDBCUtil.getInstance().executeUpdate(sql,
                new Object[]{
                        bookId, username,
                        new Date(System.currentTimeMillis())
                });
        return result;
    }
    /**
     * 查询收藏图书
     * @return
     */
    public List<Book> selectAllStore(int pageNum, int pageSize,String id){
        String sql = "select books.author,books.name,books.description,borrow_card.id\n" +
                "from books left join borrow_books on borrow_books.book_id = books.id left join borrow_card" +
                "  on borrow_card.id = borrow_books.card_id where not isnull (borrow_card.id) and " +
                "borrow_card.id = ? limit ?,?";
        List<Book> book =new ArrayList<>();
        try(ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql,
                new Object[]{id,(pageNum - 1) * pageSize, pageSize})) {
            while (rs.next()){
                Book books = new Book(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getString("description")

                );
                book.add(books);
                System.out.println(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public int countBorrowHistoryBooks(String userId) {
        String sql ="select count(*) as borrowHistoryNum  FROM borrow_books where card_id = ?";
        try (ResultSet rs = JDBCUtil.getInstance().executeQueryRS(sql, new Object[]{userId})) {
            while (rs.next()) {
                return rs.getInt("borrowHistoryNum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

        return 0;
    }
}
