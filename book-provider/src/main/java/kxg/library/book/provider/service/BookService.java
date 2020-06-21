package kxg.library.book.provider.service;

import kxg.library.book.request.AddBookRequest;
import kxg.library.book.request.DeleteByIdRequest;
import kxg.library.book.request.FindAllBookRequest;
import kxg.library.book.request.UpdateBookRequest;
import kxg.library.book.response.FindAllBookResponse;
import kxg.library.book.response.FindBookByIdResponse;
import kxg.library.book.response.FindBookResponse;
import kxg.library.book.response.IntegerResultResponse;

/**
 * 要写注释呀
 */

public interface BookService {
    IntegerResultResponse  addBookService(AddBookRequest request);
    IntegerResultResponse updateBookService(UpdateBookRequest request);
    IntegerResultResponse deleteBookService(DeleteByIdRequest request);
    FindAllBookResponse findBookByCondition(FindAllBookRequest request);
    FindBookByIdResponse findBookByIdRequest(Long id);
}
