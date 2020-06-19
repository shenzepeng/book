package kxg.library.book.provider.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 第一学历
     */
    @Column(name = "first_major")
    private String firstMajor;

    /**
     * 第二学历
     */
    @Column(name = "second_major")
    private String secondMajor;

    /**
     * 工号
     */
    @Column(name = "work_id")
    private String workId;

    /**
     * 手机号
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 头像
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 姓名
     */
    @Column(name = "chiinses_name")
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
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 密码
     */
    private String password;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 院系
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
     * 获取第一学历
     *
     * @return first_major - 第一学历
     */
    public String getFirstMajor() {
        return firstMajor;
    }

    /**
     * 设置第一学历
     *
     * @param firstMajor 第一学历
     */
    public void setFirstMajor(String firstMajor) {
        this.firstMajor = firstMajor == null ? null : firstMajor.trim();
    }

    /**
     * 获取第二学历
     *
     * @return second_major - 第二学历
     */
    public String getSecondMajor() {
        return secondMajor;
    }

    /**
     * 设置第二学历
     *
     * @param secondMajor 第二学历
     */
    public void setSecondMajor(String secondMajor) {
        this.secondMajor = secondMajor == null ? null : secondMajor.trim();
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
     * 获取手机号
     *
     * @return phone_number - 手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号
     *
     * @param phoneNumber 手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
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
     * 获取姓名
     *
     * @return chiinses_name - 姓名
     */
    public String getChiinsesName() {
        return chiinsesName;
    }

    /**
     * 设置姓名
     *
     * @param chiinsesName 姓名
     */
    public void setChiinsesName(String chiinsesName) {
        this.chiinsesName = chiinsesName == null ? null : chiinsesName.trim();
    }

    /**
     * 获取身份类型
     *
     * @return type - 身份类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置身份类型
     *
     * @param type 身份类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取身份证号
     *
     * @return id_number - 身份证号
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置身份证号
     *
     * @param idNumber 身份证号
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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
     * 获取院系
     *
     * @return department - 院系
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置院系
     *
     * @param department 院系
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }
}