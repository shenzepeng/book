package kxg.library.book.provider.service.impl;

import kxg.library.book.dto.BookListHistoryDto;
import kxg.library.book.provider.bo.BookListHistoryBo;
import kxg.library.book.provider.dao.BookListHistoryDao;
import kxg.library.book.provider.pojo.BookListHistory;
import kxg.library.book.provider.service.ReportService;
import kxg.library.book.request.FindReportRequest;
import kxg.library.book.response.FindReportResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 要写注释呀
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private BookListHistoryDao bookListHistoryDao;
    @Override
    public FindReportResponse findReport(FindReportRequest reportRequest) {
        BookListHistoryBo bookListHistory=new BookListHistoryBo();
        BeanUtils.copyProperties(reportRequest,bookListHistory);
        List<BookListHistory> bookHistoryBoByCondition = bookListHistoryDao.findBookHistoryBoByCondition(bookListHistory);

        List<BookListHistoryDto> bookListHistoryDtoList=bookHistoryBoByCondition.stream().map(new Function<BookListHistory, BookListHistoryDto>() {
            @Override
            public BookListHistoryDto apply(BookListHistory bookListHistory) {
                BookListHistoryDto bookListHistoryDto=new BookListHistoryDto();
                BeanUtils.copyProperties(bookListHistory,bookListHistoryDto);
                return bookListHistoryDto;
            }
        }).collect(Collectors.toList());
        FindReportResponse reportResponse=new FindReportResponse();
        reportResponse.setBookListHistoryDtos(bookListHistoryDtoList);
        reportResponse.setTotal((long)bookListHistoryDtoList.size());
        return reportResponse;
    }
}
