package kxg.library.book.dto;

import lombok.Data;

import java.util.Date;

/**
 * 要写注释呀
 */
@Data
public class BorrowListDto {

    private Long id;


    private Long bookId;

    private String codes;

    /**
     * 0为借阅 1借阅
     */
    private Short status;


    private Date createTime;


    private Date updateTime;

    /**
     * 借阅人的id
     */

    private Long borrowId;

    /**
     * 书名
     */
    private String chineseName;
}
