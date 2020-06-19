package kxg.library.book.provider.mapper;

import kxg.library.book.provider.common.CommonMapper;
import kxg.library.book.provider.pojo.BookListHistory;

import java.util.List;

public interface BookListHistoryMapper extends CommonMapper<BookListHistory> {
    List<BookListHistory> findBookList(BookListHistory bookListHistory);
}