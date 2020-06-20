package kxg.library.book.provider.dao;

import kxg.library.book.provider.mapper.BookMapper;
import kxg.library.book.provider.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 要写注释呀
 */
@Repository
public class BookDao {
    @Autowired
    private BookMapper bookMapper;

    public List<Book> findBookByCondition(Book book){
        return bookMapper.findAllBook(book);
    }

    public Integer addBook(Book book){
        return bookMapper.insert(book);
    }

    public Integer deleteBook(Long id){
        return bookMapper.deleteByPrimaryKey(id);
    }

    public Integer update(Book book){
        return bookMapper.updateByPrimaryKeySelective(book);
    }

    public List<Book> findAll(){
        return bookMapper.selectAll();
    }
}
