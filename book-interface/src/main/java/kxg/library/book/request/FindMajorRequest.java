package kxg.library.book.request;

import lombok.Data;

import javax.annotation.security.DenyAll;
import java.io.Serializable;

/**
 * 要写注释呀
 */
@Data
public class FindMajorRequest  implements Serializable {
    private String major;
    private String secondMajor;
    private String habbit;
    private Boolean getLowGrade;
}
