package com.test;

import kxg.library.book.provider.DubboProviderBootstrap;
import kxg.library.book.provider.mapper.BookListHistoryMapper;
import kxg.library.book.provider.mapper.BookMapper;
import kxg.library.book.provider.mapper.BorrowListMapper;
import kxg.library.book.provider.mapper.UserMapper;
import kxg.library.book.provider.pojo.Book;
import kxg.library.book.provider.pojo.BookListHistory;
import kxg.library.book.provider.pojo.BorrowList;
import kxg.library.book.provider.pojo.User;
import kxg.library.book.provider.service.SupportService;
import kxg.library.book.request.FindMajorRequest;
import kxg.library.book.response.FindSupportResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 要写注释呀
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DubboProviderBootstrap.class})
public class MapperTest {
    @Autowired
    private BookListHistoryMapper bookListHistoryMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BorrowListMapper borrowListMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SupportService supportService;
    @Test
    public void test(){
        BookListHistory bookListHistory=new BookListHistory();
        bookListHistory.setBookId(1l);
        bookListHistory.setBookName("asd");
        bookListHistory.setChineseName("asd");
        bookListHistoryMapper.findBookList(bookListHistory);


        Book book=new Book();
        bookMapper.findAllBook(book);

        BorrowList borrowList=new BorrowList();
        borrowListMapper.findAllBookList(borrowList);


        User user=new User();
        userMapper.findAllUserByCondition(user);
    }
    @Test
    public void test2(){
        FindMajorRequest request=new FindMajorRequest();
        request.setHabbit("科技");
        FindSupportResponse support = supportService.findSupport(request);
        System.out.println(support);
    }
}
