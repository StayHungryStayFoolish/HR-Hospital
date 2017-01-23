package com.hospital_hr.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * Created by bonismo@hotmail.com
 * 下午11:21 on 17/1/23.
 * <p>
 * 部门表
 */
@TableName("department")
public class Department extends Model<Department> implements Serializable {

    @TableId
    private Integer id;
    // 部门编号
    private Integer departmentNumber;
    // 部门名称
    private String name;
    // 部门经理
    private String manager;
    // 联系电话
    private String telephone;
    // 部门地址
    private String address;
    // 日志
    private String notes;

    @Override
    protected Serializable pkVal() {
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(Integer departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentNumber=" + departmentNumber +
                ", name='" + name + '\'' +
                ", manager='" + manager + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
