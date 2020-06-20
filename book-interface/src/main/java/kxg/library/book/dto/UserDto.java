package kxg.library.book.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 要写注释呀
 */
@Data
public class UserDto implements Serializable {
    private Long id;

    /**
     * 第一学历
     */
    private String firstMajor;

    /**
     * 第二学历
     */

    private String secondMajor;

    /**
     * 工号
     */

    private String workId;

    /**
     * 手机号
     */

    private String phoneNumber;

    /**
     * 头像
     */

    private String imgUrl;

    /**
     * 姓名
     */

    private String chiinsesName;

    /**
     * 身份类型
     */
    private String type;

    /**
     * 性别
     */
    private String sex;

    /**
     * 身份证号
     */

    private String idNumber;

    /**
     * 密码
     */
    private String password;


    private Date createTime;

    private Date updateTime;

    /**
     * 院系
     */
    private String department;
}
