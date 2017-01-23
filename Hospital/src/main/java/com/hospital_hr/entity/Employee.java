package com.hospital_hr.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午11:15 on 17/1/23.
 */
@TableName("employee")
public class Employee extends Model<Employee> implements Serializable {

    @TableId
    private Integer id;
    // 员工表
    private Integer employeeNumber;
    private String name;
    private String gender;
    private Date birthday;
    private String telephone;
    private String email;
    private String address;
    private String photo;
    private String education;
    private Integer departmentNumber;
    private Integer positionNumber;
    private Date inTime;
    private String password;
    private String notes;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
