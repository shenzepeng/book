package kxg.library.book.request;

import lombok.Data;

/**
 * 要写注释呀
 */
@Data
public class FindAllBookHistoryRequest {
    private Integer pageSize=1;
    private Integer pageNumber=10;

}
