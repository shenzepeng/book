package kxg.library.book.provider.controller;

import kxg.library.book.provider.config.SzpJsonResult;
import kxg.library.book.provider.service.BookService;
import kxg.library.book.request.AddBookRequest;
import kxg.library.book.request.DeleteByIdRequest;
import kxg.library.book.request.FindAllBookRequest;
import kxg.library.book.request.UpdateBookRequest;
import kxg.library.book.response.FindAllBookResponse;
import kxg.library.book.response.FindBookByIdResponse;
import kxg.library.book.response.IntegerResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 要写注释呀
 */
@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("add")
    public SzpJsonResult<IntegerResultResponse> addBookService(@RequestBody AddBookRequest request){
        return SzpJsonResult.ok(bookService.addBookService(request));
    }
    @PutMapping("update")
    public SzpJsonResult<IntegerResultResponse> updateBookService(@RequestBody UpdateBookRequest request){
        return SzpJsonResult.ok(bookService.updateBookService(request));
    }
    @DeleteMapping("delete")
    public SzpJsonResult<IntegerResultResponse> deleteBookService(@RequestBody DeleteByIdRequest request){
        return SzpJsonResult.ok(bookService.deleteBookService(request));
    }
    @PostMapping("find")
    public SzpJsonResult<FindAllBookResponse> findBookByCondition(@RequestBody FindAllBookRequest request){
        return SzpJsonResult.ok(bookService.findBookByCondition(request));
    }
    @PostMapping("find/{id}")
    public SzpJsonResult<FindBookByIdResponse> findBookById(@PathVariable("id") Long bookId){
        return SzpJsonResult.ok(bookService.findBookByIdRequest(bookId));
    }
}
