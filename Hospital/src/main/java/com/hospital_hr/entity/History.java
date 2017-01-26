package com.hospital_hr.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午9:41 on 17/1/24.
 * <p>
 * 档案表
 */
@TableName("history")
public class History extends Model<History> implements Serializable {

    @TableId
    private Integer id;
    // 部门编号
    private Integer employeeNumber;
    // 姓名
    private String name;
    // 性别
    private String gender;
    // 出生日期
    private Date birthday;
    // 电话
    private String telephone;
    // 邮箱
    private String email;
    // 籍贯
    private String address;
    // 照片
    private String photo;
    // 教育背景
    private String education;
    // 入职时间
    private Date inTime;
    // 离职时间
    private Date outTime;
    // 部门编号
    private Integer departmentNumber;
    // 职称编号
    private Integer positionNumber;
    // 状态 '离职', '在职', '退休'
    private String status;
    // 现居地
    private String home;
    // 备注
    private String notes;

    @TableField(exist = false)
    private Department department;

    @TableField(exist = false)
    private Position position;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(Integer departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public Integer getPositionNumber() {
        return positionNumber;
    }

    public void setPositionNumber(Integer positionNumber) {
        this.positionNumber = positionNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", photo='" + photo + '\'' +
                ", education='" + education + '\'' +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                ", departmentNumber=" + departmentNumber +
                ", positionNumber=" + positionNumber +
                ", status='" + status + '\'' +
                ", home='" + home + '\'' +
                ", notes='" + notes + '\'' +
                ", department=" + department +
                ", position=" + position +
                '}';
    }
}
