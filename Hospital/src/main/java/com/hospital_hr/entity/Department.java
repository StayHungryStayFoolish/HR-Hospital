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
    //
    private String address;
    private String notes;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
