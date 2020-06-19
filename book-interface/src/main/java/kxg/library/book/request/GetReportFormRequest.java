package kxg.library.book.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 获取报表
 */
@Data
public class GetReportFormRequest implements Serializable {
    private Date startTime;
    private Date endTime;
    private Integer pageNumber;
    private Integer pageSize;
}
