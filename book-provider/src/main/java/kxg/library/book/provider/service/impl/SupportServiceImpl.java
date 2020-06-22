package kxg.library.book.provider.service.impl;

import kxg.library.book.dto.BookDto;
import kxg.library.book.dto.SupportBookDto;
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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 要写注释呀
 */
@Service
public class SupportServiceImpl implements SupportService {
    @Autowired
    private BookDao bookDao;
    @Override
    public FindSupportResponse findSupport(FindMajorRequest request) {
        HashSet<SupportBookDto>  books=new HashSet<>();
        Book book=new Book();
        BeanUtils.copyProperties(request,book);
        if (!StringUtils.isEmpty(request.getHabbit())){
            book.setHabbitType(request.getHabbit());
            List<Book> bookByCondition = bookDao.findBookByCondition(book);
            books.addAll(bookToSortDto(bookByCondition));
        }
        if (!StringUtils.isEmpty(request.getMajor())){
            book.setSupportMajor(request.getMajor());
            book.setSupportMajor(null);
            List<Book> bookByCondition = bookDao.findBookByCondition(book);
            books.addAll(bookToSortDto(bookByCondition));
        }
        if (!StringUtils.isEmpty(request.getSecondMajor())){
            book.setSupportMajor(request.getSecondMajor());
            book.setSupportMajor(null);
            List<Book> bookByCondition = bookDao.findBookByCondition(book);
            books.addAll(bookToSortDto(bookByCondition));
        }
        if (CollectionUtils.isEmpty(books)&&request.getGetLowGrade()!=null){
            List<Book> all = bookDao.findAll();
            books.addAll(bookToSortDto(all));
        }
        FindSupportResponse response=new FindSupportResponse();
        response.setData(new ArrayList(books));
        response.setTotals((long)(books.size()));
        return response;
    }


    private List<SupportBookDto> bookToSortDto(List<Book> bookList){
        List<SupportBookDto> supportBookDtos = bookList.stream().map(new Function<Book, SupportBookDto>() {
            @Override
            public SupportBookDto apply(Book book) {
                SupportBookDto supportBookDto=new SupportBookDto();
                BeanUtils.copyProperties(book,supportBookDto);
                int anInt = Integer.parseInt(book.getBookGrades());
                supportBookDto.setBookGrades(anInt);
                return supportBookDto;
            }
        }).collect(Collectors.toList());
        return supportBookDtos.stream().sorted(Comparator.comparing(SupportBookDto::getBookGrades)).collect(Collectors.toList());
    }
}
