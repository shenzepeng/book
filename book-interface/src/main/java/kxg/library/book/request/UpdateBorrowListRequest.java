package kxg.library.book.request;

import lombok.Data;

import java.util.Date;

/**
 * 要写注释呀
 */
@Data
public class UpdateBorrowListRequest {

    private Long id;


    private Long bookId;

    private String codes;

    /**
     * 0为借阅 1借阅
     */
    private Short status;


    /**
     * 借阅人的id
     */
    private Long borrowId;

    /**
     * 书名
     */
    private String chineseName;

}
