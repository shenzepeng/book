package kxg.library.book.provider.dao;

import kxg.library.book.provider.mapper.BookMapper;
import kxg.library.book.provider.mapper.BorrowListMapper;
import kxg.library.book.provider.pojo.BorrowList;
import kxg.library.book.request.FindAllBookRequest;
import kxg.library.book.request.FindAllBorrowListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 要写注释呀
 */
@Repository
public class BorrowListDao {
    @Autowired
    private BorrowListMapper borrowListMapper;

    public List<BorrowList> findBorrowList(BorrowList borrowList){
        return borrowListMapper.findAllBookList(borrowList);
    }

    public Integer delete(Long id){
        return borrowListMapper.deleteByPrimaryKey(id);
    }

    public Integer update(BorrowList borrowList){
        return borrowListMapper.updateByPrimaryKeySelective(borrowList);
    }

    public Integer add(BorrowList borrowList){
        return borrowListMapper.insert(borrowList);
    }

    public Integer addList(List<BorrowList> borrowLists){
        return borrowListMapper.insertList(borrowLists);
    }
}
