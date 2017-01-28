package com.hospital_hr.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午4:42 on 17/1/28.
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
}
