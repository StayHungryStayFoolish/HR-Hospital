package com.hospital_hr.entity;

import com.baomidou.mybatisplus.activerecord.Model;
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
    private String education;
    private Date inTime;
    private Date outTime;
    private Integer departmentNumber;
    private Integer positionNumber;
    private String status;
    private String home;
    private String notes;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
