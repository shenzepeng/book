package kxg.library.book.provider.service;

import kxg.library.book.request.*;
import kxg.library.book.response.FindAllBookResponse;
import kxg.library.book.response.FindAllBorrowListResponse;
import kxg.library.book.response.IntegerResultResponse;

/**
 * 要写注释呀
 */
public interface BorrowListService {
    FindAllBorrowListResponse findBookByCondition(FindAllBorrowListRequest request);
    IntegerResultResponse add(AddBorrowListRequest request);
    IntegerResultResponse update(UpdateBorrowListRequest request);
    IntegerResultResponse delete(DeleteByIdRequest request);
}
