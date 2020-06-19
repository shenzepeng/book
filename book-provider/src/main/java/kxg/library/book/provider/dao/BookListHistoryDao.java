package kxg.library.book.provider.dao;

import kxg.library.book.provider.mapper.BookListHistoryMapper;
import kxg.library.book.provider.pojo.BookListHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 要写注释呀
 */
@Repository
public class BookListHistoryDao {
    @Autowired
    private BookListHistoryMapper bookListHistoryMapper;

    public List<BookListHistory> findBookHistoryByCondition(BookListHistory bookListHistory){
        return bookListHistoryMapper.findBookList(bookListHistory);
    }
}
