package kxg.library.book.provider.mapper;

import kxg.library.book.provider.common.CommonMapper;
import kxg.library.book.provider.pojo.BorrowList;

import java.util.List;

public interface BorrowListMapper extends CommonMapper<BorrowList> {
    List<BorrowList> findAllBookList(BorrowList borrowList);
}