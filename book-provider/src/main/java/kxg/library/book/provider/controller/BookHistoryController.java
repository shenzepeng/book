package kxg.library.book.provider.controller;

import kxg.library.book.provider.config.SzpJsonResult;
import kxg.library.book.provider.service.BookHistoryService;
import kxg.library.book.request.*;
import kxg.library.book.response.FindAllBorrowListResponse;
import kxg.library.book.response.IntegerResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 要写注释呀
 */
@RestController
@RequestMapping("borrow/history")
public class BookHistoryController {
    @Autowired
    private BookHistoryService bookHistoryService;
    @PostMapping("add")
    public SzpJsonResult<IntegerResultResponse> addBorrowHistory(@RequestBody AddBookRequest bookRequest){
        return SzpJsonResult.ok(bookHistoryService.addBorrowHistory(bookRequest));
    }
    @PutMapping("update")
    public SzpJsonResult<IntegerResultResponse> updateBorrow(@RequestBody UpdateBookRequest request){
        return SzpJsonResult.ok(bookHistoryService.updateBorrow(request));
    }
    @DeleteMapping("delete")
    public SzpJsonResult<IntegerResultResponse> deleteBorrow(@RequestBody DeleteByIdRequest request){
        return SzpJsonResult.ok(bookHistoryService.deleteBorrow(request));
    }
    @PostMapping("find")
    public SzpJsonResult<FindAllBorrowListResponse> findAll(@RequestBody FindAllBookHistoryRequest request){
        return SzpJsonResult.ok(bookHistoryService.findAll(request));
    }

}
