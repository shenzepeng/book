package kxg.library.book.request;

import lombok.Data;

import java.util.Date;

/**
 * 要写注释呀
 */
@Data
public class UpdateBookRequest {
    private Long id;

    /**
     * 书名
     */

    private String bookName;

    /**
     * 多少个
     */

    private Integer bookSize;

    /**
     * 评分
     */

    private String bookGrades;

    /**
     * 推荐爱好
     */

    private String habbitType;

    /**
     * 支持专业
     */

    private String supportMajor;

    /**
     * 作者
     */
    private String author;

    /**
     * 语言
     */
    private String language;



    /**
     * 头像
     */
    private String imgUrl;

    /**
     * 价格
     */
    private String preice;
}
