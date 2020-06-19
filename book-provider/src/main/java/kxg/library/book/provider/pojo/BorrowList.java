package kxg.library.book.provider.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_borrow_list")
public class BorrowList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    private String codes;

    /**
     * 0为借阅 1借阅
     */
    private Short status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 借阅人的id
     */
    @Column(name = "borrow_id")
    private Long borrowId;

    /**
     * 书名
     */
    @Column(name = "chinese_name")
    private String chineseName;

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
     * @return book_id
     */
    public Long getBookId() {
        return bookId;
    }

    /**
     * @param bookId
     */
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    /**
     * @return codes
     */
    public String getCodes() {
        return codes;
    }

    /**
     * @param codes
     */
    public void setCodes(String codes) {
        this.codes = codes == null ? null : codes.trim();
    }

    /**
     * 获取0为借阅 1借阅
     *
     * @return status - 0为借阅 1借阅
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置0为借阅 1借阅
     *
     * @param status 0为借阅 1借阅
     */
    public void setStatus(Short status) {
        this.status = status;
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
     * 获取借阅人的id
     *
     * @return borrow_id - 借阅人的id
     */
    public Long getBorrowId() {
        return borrowId;
    }

    /**
     * 设置借阅人的id
     *
     * @param borrowId 借阅人的id
     */
    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    /**
     * 获取书名
     *
     * @return chinese_name - 书名
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * 设置书名
     *
     * @param chineseName 书名
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }
}