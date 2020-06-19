package kxg.library.book.provider.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 书名
     */
    @Column(name = "book_name")
    private String bookName;

    /**
     * 多少个
     */
    @Column(name = "book_size")
    private Integer bookSize;

    /**
     * 评分
     */
    @Column(name = "book_grades")
    private String bookGrades;

    /**
     * 推荐爱好
     */
    @Column(name = "habbit_type")
    private String habbitType;

    /**
     * 支持专业
     */
    @Column(name = "support_major")
    private String supportMajor;

    /**
     * 作者
     */
    private String author;

    /**
     * 语言
     */
    private String language;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 头像
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 价格
     */
    private String preice;

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
     * 获取多少个
     *
     * @return book_size - 多少个
     */
    public Integer getBookSize() {
        return bookSize;
    }

    /**
     * 设置多少个
     *
     * @param bookSize 多少个
     */
    public void setBookSize(Integer bookSize) {
        this.bookSize = bookSize;
    }

    /**
     * 获取评分
     *
     * @return book_grades - 评分
     */
    public String getBookGrades() {
        return bookGrades;
    }

    /**
     * 设置评分
     *
     * @param bookGrades 评分
     */
    public void setBookGrades(String bookGrades) {
        this.bookGrades = bookGrades == null ? null : bookGrades.trim();
    }

    /**
     * 获取推荐爱好
     *
     * @return habbit_type - 推荐爱好
     */
    public String getHabbitType() {
        return habbitType;
    }

    /**
     * 设置推荐爱好
     *
     * @param habbitType 推荐爱好
     */
    public void setHabbitType(String habbitType) {
        this.habbitType = habbitType == null ? null : habbitType.trim();
    }

    /**
     * 获取支持专业
     *
     * @return support_major - 支持专业
     */
    public String getSupportMajor() {
        return supportMajor;
    }

    /**
     * 设置支持专业
     *
     * @param supportMajor 支持专业
     */
    public void setSupportMajor(String supportMajor) {
        this.supportMajor = supportMajor == null ? null : supportMajor.trim();
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 获取语言
     *
     * @return language - 语言
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置语言
     *
     * @param language 语言
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
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
     * 获取头像
     *
     * @return img_url - 头像
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置头像
     *
     * @param imgUrl 头像
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取价格
     *
     * @return preice - 价格
     */
    public String getPreice() {
        return preice;
    }

    /**
     * 设置价格
     *
     * @param preice 价格
     */
    public void setPreice(String preice) {
        this.preice = preice == null ? null : preice.trim();
    }
}