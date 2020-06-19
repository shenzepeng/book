package kxg.library.book.provider.mapper;

import kxg.library.book.provider.common.CommonMapper;
import kxg.library.book.provider.pojo.Book;

import java.util.List;

public interface BookMapper extends CommonMapper<Book> {
    List<Book> findAllBook(Book book);
}