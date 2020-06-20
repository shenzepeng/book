package kxg.library.book.response;

import kxg.library.book.dto.BookDto;
import lombok.Data;

import java.util.List;

/**
 * 要写注释呀
 */
@Data
public class FindAllBookResponse {
    private List<BookDto> data;
    private Long totals;
}
