package kxg.library.book.provider.service;

import kxg.library.book.request.*;
import kxg.library.book.response.FindAllBookHistoryResponse;
import kxg.library.book.response.FindAllBorrowListResponse;
import kxg.library.book.response.IntegerResultResponse;

/**
 * 要写注释呀
 */
public interface BookHistoryService {
    IntegerResultResponse addBorrowHistory(AddBookHistoryRequest bookRequest);
    IntegerResultResponse updateBorrow(UpdateBookHistoryRequest request);
    IntegerResultResponse deleteBorrow(DeleteByIdRequest request);
    FindAllBookHistoryResponse findAll(FindAllBookHistoryRequest request);
}
