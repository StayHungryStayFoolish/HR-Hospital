package com.hospital_hr.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午4:42 on 17/1/28.
 * <p>
 * 奖罚记录表
 */
@TableName("rewards_punishment")
public class RewardsPunishment extends Model<RewardsPunishment> implements Serializable {

    @TableId
    private Integer id;
    // 员工编号
    private Integer employeeNumber;
    // 类型
    private String type;
    // 原因
    private String reason;
    // 金额
    private Float money;
    // 时间
    private Date time;
    // 经理
    private String manager;
    // 备注
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

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
