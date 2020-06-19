package kxg.library.book.provider.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_borrow_list_history")
public class BookListHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 书的id
     */
    @Column(name = "book_id")
    private Long bookId;

    /**
     * 书名
     */
    @Column(name = "book_name")
    private String bookName;

    /**
     * 书的爱好
     */
    @Column(name = "habbit_type")
    private String habbitType;

    /**
     * 支持类型
     */
    @Column(name = "support_major")
    private String supportMajor;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 工号
     */
    @Column(name = "work_id")
    private String workId;

    /**
     * 汉语名
     */
    @Column(name = "chinese_name")
    private String chineseName;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 学院
     */
    private String department;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取书的id
     *
     * @return book_id - 书的id
     */
    public Long getBookId() {
        return bookId;
    }

    /**
     * 设置书的id
     *
     * @param bookId 书的id
     */
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    /**
     * 获取书名
     *
     * @return book_name - 书名
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 设置书名
     *
     * @param bookName 书名
     */
    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    /**
     * 获取书的爱好
     *
     * @return habbit_type - 书的爱好
     */
    public String getHabbitType() {
        return habbitType;
    }

    /**
     * 设置书的爱好
     *
     * @param habbitType 书的爱好
     */
    public void setHabbitType(String habbitType) {
        this.habbitType = habbitType == null ? null : habbitType.trim();
    }

    /**
     * 获取支持类型
     *
     * @return support_major - 支持类型
     */
    public String getSupportMajor() {
        return supportMajor;
    }

    /**
     * 设置支持类型
     *
     * @param supportMajor 支持类型
     */
    public void setSupportMajor(String supportMajor) {
        this.supportMajor = supportMajor == null ? null : supportMajor.trim();
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取工号
     *
     * @return work_id - 工号
     */
    public String getWorkId() {
        return workId;
    }

    /**
     * 设置工号
     *
     * @param workId 工号
     */
    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    /**
     * 获取汉语名
     *
     * @return chinese_name - 汉语名
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * 设置汉语名
     *
     * @param chineseName 汉语名
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取学院
     *
     * @return department - 学院
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置学院
     *
     * @param department 学院
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }
}