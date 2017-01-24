package com.hospital_hr.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午10:08 on 17/1/24.
 * <p>
 * 员工调动记录表
 */
@TableName("move")
public class Move extends Model<Move> implements Serializable {

    @TableId
    private Integer id;
    // 员工编号
    private Integer employeeNumber;
    // 调动前调动前部门编号
    private Integer ago;
    // 调动后调动前部门编号
    private Integer after;
    // 调动时间
    private Date time;
    // 经理
    private String manager;
    // 日志
    private String notes;

    @TableField(exist = false)
    private Employee employee;

    @TableField(exist = false)
    private Department department1;

    @TableField(exist = false)
    private Department department2;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
