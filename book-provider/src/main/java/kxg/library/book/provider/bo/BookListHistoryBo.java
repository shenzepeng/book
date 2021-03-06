package kxg.library.book.provider.bo;

import lombok.Data;

import java.util.Date;

/**
 * 要写注释呀
 */
@Data
public class BookListHistoryBo {
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

    private Date startTime;
    private Date endTime;
}
