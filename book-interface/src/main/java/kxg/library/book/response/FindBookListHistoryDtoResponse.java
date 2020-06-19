package kxg.library.book.response;

import kxg.library.book.dto.BookListHistoryDto;
import lombok.Data;

import java.util.List;

/**
 * 要写注释呀
 */
@Data
public class FindBookListHistoryDtoResponse {
    private List<BookListHistoryDto> bookListHistoryDtos;
    private Long total;
}
