package kxg.library.book.provider.controller;

import kxg.library.book.provider.config.SzpJsonResult;
import kxg.library.book.provider.dao.BorrowListDao;
import kxg.library.book.provider.pojo.BorrowList;
import kxg.library.book.provider.service.BorrowListService;
import kxg.library.book.request.AddBorrowListRequest;
import kxg.library.book.request.DeleteByIdRequest;
import kxg.library.book.request.FindAllBorrowListRequest;
import kxg.library.book.request.UpdateBorrowListRequest;
import kxg.library.book.response.FindAllBorrowListResponse;
import kxg.library.book.response.IntegerResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 要写注释呀
 */
@RestController
@RequestMapping("borrow")
public class BorrowListController {
    @Autowired
    private BorrowListService borrowListService;
    @PostMapping
    public SzpJsonResult<FindAllBorrowListResponse> findBookByCondition(@RequestBody FindAllBorrowListRequest request){
        return SzpJsonResult.ok(borrowListService.findBookByCondition(request));
    }
    @PostMapping("add")
    public SzpJsonResult<IntegerResultResponse> add(@RequestBody AddBorrowListRequest request){
        return SzpJsonResult.ok(borrowListService.add(request));
    }
    @PostMapping("update")
    public SzpJsonResult<IntegerResultResponse> update(@RequestBody UpdateBorrowListRequest request){
        return SzpJsonResult.ok(borrowListService.update(request));
    }
    @DeleteMapping
    public SzpJsonResult<IntegerResultResponse> delete(@RequestBody DeleteByIdRequest request){
        return SzpJsonResult.ok(borrowListService.delete(request));
    }
}
