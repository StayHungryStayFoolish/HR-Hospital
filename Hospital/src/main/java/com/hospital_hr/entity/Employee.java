package com.hospital_hr.entity;

import com.baomidou.mybatisplus.activerecord.Model;
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



    @Override
    protected Serializable pkVal() {
        return null;
    }
}
