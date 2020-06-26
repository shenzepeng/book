package kxg.library.book.provider.controller;

import com.google.gson.internal.$Gson$Types;
import io.netty.handler.codec.http.HttpResponse;
import kxg.library.book.constant.Constants;
import kxg.library.book.dto.BookDto;
import kxg.library.book.dto.UserDto;
import kxg.library.book.provider.config.SzpJsonResult;
import kxg.library.book.provider.dao.BookDao;
import kxg.library.book.provider.dao.BorrowListDao;
import kxg.library.book.provider.dao.UserDao;
import kxg.library.book.provider.pojo.Book;
import kxg.library.book.provider.pojo.BorrowList;
import kxg.library.book.provider.pojo.User;
import kxg.library.book.provider.service.BookService;
import kxg.library.book.provider.service.UserService;
import kxg.library.book.provider.utils.ExcelBookInfoToDBUtils;
import kxg.library.book.provider.utils.ExcelUserIfnoToDBUtils;
import kxg.library.book.response.IntegerResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 要写注释呀
 */
@Slf4j
@RestController
@RequestMapping("excel")
public class ExcelUpload {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowListDao borrowListDao;
    @PostMapping("user")
    public SzpJsonResult<IntegerResultResponse> addUser(MultipartFile file, HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        List<UserDto> excelToDb = ExcelUserIfnoToDBUtils.getExcelToDb(file);
        List<User> userList = excelToDb.stream().map(new Function<UserDto, User>() {
            @Override
            public User apply(UserDto userDto) {
                User user=new User();
                BeanUtils.copyProperties(userDto,user);
                user.setCreateTime(new Date());
                user.setUpdateTime(new Date());
                return user;
            }
        }).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(userList)){
            throw new RuntimeException("用户信息不能为空");
        }
        IntegerResultResponse response=new IntegerResultResponse();
        Integer result = userDao.addUserList(userList);
        response.setEnd(result);
        return SzpJsonResult.ok(response);
    }

    @PostMapping("book")
    public SzpJsonResult<IntegerResultResponse> addBook(MultipartFile file, HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        List<BookDto> excelToDb = ExcelBookInfoToDBUtils.getExcelToDb(file);
        log.info("excelToDb - {}",excelToDb);
        List<Book> bookList = excelToDb.stream().map(new Function<BookDto, Book>() {
            @Override
            public Book apply(BookDto bookDto) {
                Book book = new Book();
                BeanUtils.copyProperties(bookDto, book);
                book.setCreateTime(new Date());
                book.setUpdateTime(new Date());
                return book;
            }
        }).collect(Collectors.toList());
        Integer result = bookDao.addBooks(bookList);
        List<BorrowList> borrowLists=new ArrayList<>();
        for (Book book : bookList) {
           for (int i=0;i<book.getBookSize();i++){
               BorrowList borrowList=new BorrowList();
               borrowList.setCodes(UUID.randomUUID().toString());
               borrowList.setBookId(book.getId());
               borrowList.setUpdateTime(new Date());
               borrowList.setCreateTime(new Date());
               borrowList.setStatus(Constants.NOT_BORROW);
               borrowLists.add(borrowList);
           }
        }
        if (!CollectionUtils.isEmpty(borrowLists)){
            borrowListDao.addList(borrowLists);
        }
        IntegerResultResponse response=new IntegerResultResponse();
        response.setEnd(result);
        return SzpJsonResult.ok(response);
    }
}
