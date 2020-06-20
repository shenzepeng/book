package kxg.library.book.response;

import kxg.library.book.dto.BorrowListDto;
import lombok.Data;

import java.util.List;

/**
 * 要写注释呀
 */
@Data
public class FindBorrowDtoResponse {
    private List<BorrowListDto> data;
    private Long totals;
}
