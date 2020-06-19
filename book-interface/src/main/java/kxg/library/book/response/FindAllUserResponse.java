package kxg.library.book.response;

import kxg.library.book.dto.UserDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 要写注释呀
 */
@Data
public class FindAllUserResponse implements Serializable {
    private List<UserDto> userDtoList;
    private Long total;
}
