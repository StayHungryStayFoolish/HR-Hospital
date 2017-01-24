package com.hospital_hr.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午10:14 on 17/1/24.
 * <p>
 * 加班表
 */
@TableName("overtime")
public class Overtime extends Model<Overtime> implements Serializable {

    @TableId
    private Integer id;
    // 部门编号
    private Integer departmentNumber;
    // 员工编号
    private Integer employeeNumber;
    // 日期
    private Date day;
    // 开始时间
    private Date startTime;
    // 结束时间
    private Date endTime;
    // 备注
    private String notes;

    @TableField(exist = false)
    private Department department;

    @TableField(exist = false)
    private Employee employee;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
