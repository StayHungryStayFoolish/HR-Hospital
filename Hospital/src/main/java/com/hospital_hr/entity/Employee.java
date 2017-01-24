package com.hospital_hr.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午11:15 on 17/1/23.
 * <p>
 * 员工表
 */
@TableName("employee")
public class Employee extends Model<Employee> implements Serializable {

    @TableId
    private Integer id;
    // 员工表
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
    // 地址
    private String address;
    // 照片
    private String photo;
    // 教育背景
    private String education;
    // 部门编号
    private Integer departmentNumber;
    // 职称编号
    private Integer positionNumber;
    // 入职时间
    private Date inTime;
    // 密码
    private String password;
    // 备注
    private String notes;

    @TableField(exist = false)
    private Department department;

    @TableField(exist = false)
    private Posistion posistion;

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

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Posistion getPosistion() {
        return posistion;
    }

    public void setPosistion(Posistion posistion) {
        this.posistion = posistion;
    }

    @Override
    public String toString() {
        return "Employee{" +
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
                ", departmentNumber=" + departmentNumber +
                ", positionNumber=" + positionNumber +
                ", inTime=" + inTime +
                ", password='" + password + '\'' +
                ", notes='" + notes + '\'' +
                ", department=" + department +
                ", posistion=" + posistion +
                '}';
    }
}
