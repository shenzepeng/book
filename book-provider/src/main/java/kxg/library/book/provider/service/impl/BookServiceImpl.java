package kxg.library.book.provider.service.impl;

import kxg.library.book.provider.service.BookService;
import kxg.library.book.request.AddBookRequest;
import kxg.library.book.request.DeleteByIdRequest;
import kxg.library.book.request.FindAllBookRequest;
import kxg.library.book.request.UpdateBookRequest;
import kxg.library.book.response.IntegerResultResponse;
import org.apache.dubbo.config.annotation.Service;

/**
 * 要写注释呀
 */
@Service
public class BookServiceImpl  implements BookService {
    @Override
    public IntegerResultResponse addBookService(AddBookRequest request) {
        return null;
    }

    @Override
    public IntegerResultResponse updateBookService(UpdateBookRequest request) {
        return null;
    }

    @Override
    public IntegerResultResponse deleteBookService(DeleteByIdRequest request) {
        return null;
    }

    @Override
    public FindAllBookRequest findBookByCondition(FindAllBookRequest request) {
        return null;
    }
}
