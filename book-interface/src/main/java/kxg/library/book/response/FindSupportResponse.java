package kxg.library.book.response;

import kxg.library.book.dto.BookDto;
import kxg.library.book.dto.SupportBookDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 要写注释呀
 */
@Data
public class FindSupportResponse implements Serializable {
    private List<SupportBookDto> data;
    private Long totals;
}
