package kxg.library.book.response;

import kxg.library.book.dto.BookDto;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * 要写注释呀
 */
@Data
public class FindBookResponse implements Serializable {
    private List<BookDto> bookDtos;
    private Long total;
}
