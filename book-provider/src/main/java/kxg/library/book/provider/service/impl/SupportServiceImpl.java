package kxg.library.book.provider.service.impl;

import kxg.library.book.dto.BookDto;
import kxg.library.book.provider.dao.BookDao;
import kxg.library.book.provider.pojo.Book;
import kxg.library.book.provider.service.SupportService;
import kxg.library.book.request.FindMajorRequest;
import kxg.library.book.response.FindSupportResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;

/**
 * 要写注释呀
 */
@Service
public class SupportServiceImpl implements SupportService {
    @Autowired
    private BookDao bookDao;
    @Override
    public FindSupportResponse findSupport(FindMajorRequest request) {
        HashSet<Book>  books=new HashSet<>();
        Book book=new Book();
        BeanUtils.copyProperties(request,book);
        if (!StringUtils.isEmpty(request.getMajor())){
            book.setSupportMajor(request.getMajor());
            book.setSupportMajor(null);
            List<Book> bookByCondition = bookDao.findBookByCondition(book);
            books.addAll(bookByCondition);
        }
        if (!StringUtils.isEmpty(request.getSecondMajor())){
            book.setSupportMajor(request.getSecondMajor());
            book.setSupportMajor(null);
            List<Book> bookByCondition = bookDao.findBookByCondition(book);
            books.addAll(bookByCondition);
        }
        if (CollectionUtils.isEmpty(books)&&request.getGetLowGrade()!=null){
            bookDao.findAll();
        }
        return null;
    }
}
