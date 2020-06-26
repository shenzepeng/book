package kxg.library.book.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import kxg.library.book.dto.BorrowListDto;
import kxg.library.book.provider.dao.BorrowListDao;
import kxg.library.book.provider.pojo.BorrowList;
import kxg.library.book.provider.service.BorrowListService;
import kxg.library.book.request.AddBorrowListRequest;
import kxg.library.book.request.DeleteByIdRequest;
import kxg.library.book.request.FindAllBorrowListRequest;
import kxg.library.book.request.UpdateBorrowListRequest;
import kxg.library.book.response.FindAllBorrowListResponse;
import kxg.library.book.response.IntegerResultResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 要写注释呀
 */
@Service
public class BorrowListImpl  implements BorrowListService {
    @Autowired
    private BorrowListDao borrowListDao;
    @Override
    public FindAllBorrowListResponse findBookByCondition(FindAllBorrowListRequest request) {
        FindAllBorrowListResponse response=new FindAllBorrowListResponse();
        BorrowList borrowList=new BorrowList();
        BeanUtils.copyProperties(request,borrowList);
        PageHelper.startPage(request.getPageNumber(),request.getPageSize());
        List<BorrowList> borrowListDaoBorrowList = borrowListDao.findBorrowList(borrowList);
        PageInfo<BorrowList> pageInfo=new PageInfo<>(borrowListDaoBorrowList);
        List<BorrowListDto> borrowListDtos = pageInfo.getList().stream().map(new Function<BorrowList, BorrowListDto>() {
            @Override
            public BorrowListDto apply(BorrowList borrowList) {
                BorrowListDto borrowListDto = new BorrowListDto();
                BeanUtils.copyProperties(borrowList, borrowListDto);
                return borrowListDto;
            }
        }).collect(Collectors.toList());
        response.setData(borrowListDtos);
        response.setTotals(pageInfo.getTotal());
        return response;
    }

    @Override
    public IntegerResultResponse add(AddBorrowListRequest request) {
        IntegerResultResponse response=new IntegerResultResponse();
        BorrowList borrowList=new BorrowList();
        BeanUtils.copyProperties(request,borrowList);
        borrowList.setCreateTime(new Date());
        borrowList.setUpdateTime(new Date());
        Integer result = borrowListDao.add(borrowList);
        response.setEnd(result);
        return response;
    }

    @Override
    public IntegerResultResponse update(UpdateBorrowListRequest request) {
        IntegerResultResponse response=new IntegerResultResponse();
        BorrowList borrowList=new BorrowList();
        BeanUtils.copyProperties(request,borrowList);
        borrowList.setCreateTime(new Date());
        borrowList.setUpdateTime(new Date());
        Integer result = borrowListDao.update(borrowList);
        response.setEnd(result);
        return response;
    }

    @Override
    public IntegerResultResponse delete(DeleteByIdRequest request) {
        IntegerResultResponse response=new IntegerResultResponse();
        Integer result = borrowListDao.delete(request.getId());
        response.setEnd(result);
        return response;
    }
}
