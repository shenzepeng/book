package kxg.library.book.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import kxg.library.book.dto.BookListHistoryDto;
import kxg.library.book.dto.BorrowListDto;
import kxg.library.book.provider.dao.BookListHistoryDao;
import kxg.library.book.provider.dao.BorrowListDao;

import kxg.library.book.provider.pojo.BookListHistory;
import kxg.library.book.provider.pojo.BorrowList;
import kxg.library.book.provider.service.BookHistoryService;

import kxg.library.book.request.*;

import kxg.library.book.response.FindAllBookHistoryResponse;
import kxg.library.book.response.FindAllBorrowListResponse;
import kxg.library.book.response.IntegerResultResponse;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * 要写注释呀
 */
@Service
public class BookHistoryServiceImpl implements BookHistoryService {
    @Autowired
    private BorrowListDao borrowListDao;
    @Autowired
    private BookListHistoryDao bookListHistoryDao;
    @Override
    public IntegerResultResponse addBorrowHistory(AddBookRequest bookRequest) {
        IntegerResultResponse response=new IntegerResultResponse();
        BookListHistory bookListHistory=new BookListHistory();
        BeanUtils.copyProperties(bookRequest,bookListHistory);
        bookListHistory.setCreateTime(new Date());
        bookListHistory.setUpdateTime(new Date());
        Integer result = bookListHistoryDao.add(bookListHistory);

        response.setEnd(result);
        return response;
    }

    @Override
    public IntegerResultResponse updateBorrow(UpdateBookRequest request) {
        IntegerResultResponse response=new IntegerResultResponse();
        BookListHistory borrowList=new BookListHistory();
        BeanUtils.copyProperties(request,borrowList);
        borrowList.setUpdateTime(new Date());
        borrowList.setCreateTime(new Date());
        Integer result = bookListHistoryDao.update(borrowList);
        response.setEnd(result);
        return response;
    }

    @Override
    public IntegerResultResponse deleteBorrow(DeleteByIdRequest request) {
        IntegerResultResponse response=new IntegerResultResponse();
        Integer result = bookListHistoryDao.delete(request.getId());
        response.setEnd(result);
        return response;
    }



    @Override
    public FindAllBookHistoryResponse findAll(FindAllBookHistoryRequest request) {
        FindAllBookHistoryResponse response=new FindAllBookHistoryResponse();
        BookListHistory borrowList=new BookListHistory();
        BeanUtils.copyProperties(request,borrowList);
        PageHelper.startPage(request.getPageNumber(),request.getPageSize());
        List<BookListHistory> borrowLists = bookListHistoryDao.findBookHistoryByCondition(borrowList);
        PageInfo<BookListHistory> borrowListPageInfo=new PageInfo<>(borrowLists);

        List<BookListHistoryDto> borrowListDtoList = borrowListPageInfo.getList().stream().map(new Function<BookListHistory, BookListHistoryDto>() {
            @Override
            public BookListHistoryDto apply(BookListHistory borrowList) {
                BookListHistoryDto borrowListDto = new BookListHistoryDto();
                BeanUtils.copyProperties(borrowList, borrowListDto);
                return borrowListDto;
            }
        }).collect(Collectors.toList());
        response.setTotals(borrowListPageInfo.getTotal());
        response.setData(borrowListDtoList);
        return response;
    }


}
