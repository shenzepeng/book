package kxg.library.book.request;

import lombok.Data;

import java.util.Date;

/**
 * 要写注释呀
 */
@Data
public class UpdateBookHistoryRequest {
    private Long id;

    /**
     * 书的id
     */
    private Long bookId;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 书的爱好
     */

    private String habbitType;

    /**
     * 支持类型
     */

    private String supportMajor;

    /**
     * 用户id
     */

    private Long userId;

    /**
     * 工号
     */

    private String workId;

    /**
     * 汉语名
     */

    private String chineseName;


    /**
     * 学院
     */
    private String department;
}
