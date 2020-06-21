package kxg.library.book.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import kxg.library.book.constant.Constants;
import kxg.library.book.dto.BookDto;
import kxg.library.book.provider.dao.BookDao;
import kxg.library.book.provider.dao.BookListHistoryDao;
import kxg.library.book.provider.dao.BorrowListDao;
import kxg.library.book.provider.pojo.Book;
import kxg.library.book.provider.pojo.BookListHistory;
import kxg.library.book.provider.pojo.BorrowList;
import kxg.library.book.provider.service.BookService;
import kxg.library.book.request.AddBookRequest;
import kxg.library.book.request.DeleteByIdRequest;
import kxg.library.book.request.FindAllBookRequest;
import kxg.library.book.request.UpdateBookRequest;
import kxg.library.book.response.FindAllBookResponse;
import kxg.library.book.response.FindBookByIdResponse;
import kxg.library.book.response.IntegerResultResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 要写注释呀
 */
@Service
public class BookServiceImpl  implements BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BorrowListDao borrowListDao;
    @Override
    public IntegerResultResponse addBookService(AddBookRequest request) {
        IntegerResultResponse response=new IntegerResultResponse();
        Book book=new Book();
        BeanUtils.copyProperties(request,book);
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        Integer result = bookDao.addBook(book);
        if (book.getBookSize()>=1){
            List<BorrowList> borrowLists=new ArrayList<>();
            for (int i=0;i<book.getBookSize();i++){
                BorrowList borrowList=new BorrowList();
                borrowList.setCreateTime(new Date());
                borrowList.setUpdateTime(new Date());
                borrowList.setBookId(book.getId());
                borrowList.setCodes(UUID.randomUUID().toString());
                borrowList.setStatus(Constants.NOT_BORROW);
                borrowLists.add(borrowList);
            }
            if (!CollectionUtils.isEmpty(borrowLists)){
                borrowListDao.addList(borrowLists);
            }
        }
        response.setEnd(result);
        return response;
    }

    @Override
    public IntegerResultResponse updateBookService(UpdateBookRequest request) {
        IntegerResultResponse response=new IntegerResultResponse();
        Book book=new Book();
        BeanUtils.copyProperties(request,book);

        book.setUpdateTime(new Date());
        Integer result = bookDao.update(book);
        response.setEnd(result);
        return response;
    }

    @Override
    public IntegerResultResponse deleteBookService(DeleteByIdRequest request) {
        IntegerResultResponse response=new IntegerResultResponse();
        Integer result = bookDao.deleteBook(request.getId());
        response.setEnd(result);
        return response;
    }

    @Override
    public FindAllBookResponse findBookByCondition(FindAllBookRequest request) {
        FindAllBookResponse response=new FindAllBookResponse();
        Book book=new Book();
        BeanUtils.copyProperties(request,book);
        book.setUpdateTime(new Date());
        book.setCreateTime(new Date());
        PageHelper.startPage(request.getPageNumber(),request.getPageSize());
        List<Book> bookByCondition = bookDao.findBookByCondition(book);
        PageInfo<Book> pageInfo=new PageInfo<>(bookByCondition);
        List<BookDto> bookDtoList = pageInfo.getList().stream().map(new Function<Book, BookDto>() {
            @Override
            public BookDto apply(Book book) {
                BookDto bookDto = new BookDto();
                BeanUtils.copyProperties(book, bookDto);
                return bookDto;
            }
        }).collect(Collectors.toList());
        response.setData(bookDtoList);
        response.setTotals(pageInfo.getTotal());
        return response;
    }

    @Override
    public FindBookByIdResponse findBookByIdRequest(Long id) {
        FindBookByIdResponse response=new FindBookByIdResponse();
        Book bookById = bookDao.findBookById(id);
        BeanUtils.copyProperties(bookById,response);
        return response;
    }
}
