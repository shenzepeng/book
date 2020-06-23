package kxg.library.book.provider.service.impl;

import kxg.library.book.provider.bo.BookListHistoryBo;
import kxg.library.book.provider.dao.BookListHistoryDao;
import kxg.library.book.provider.pojo.BookListHistory;
import kxg.library.book.provider.service.ReportService;
import kxg.library.book.request.FindReportRequest;
import kxg.library.book.response.FindReportResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

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
        bookHistoryBoByCondition.stream().map(new Function<BookListHistory, Object>() {
        })
        return null;
    }
}
