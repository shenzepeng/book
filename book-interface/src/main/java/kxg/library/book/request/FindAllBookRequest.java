package kxg.library.book.request;

import kxg.library.book.dto.BookDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 要写注释呀
 */
@Data
public class FindAllBookRequest {
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

    private Integer pageNumber=10;
    private Integer pageSize=1;
}
