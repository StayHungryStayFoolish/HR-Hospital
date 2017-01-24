package com.hospital_hr.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午9:55 on 17/1/24.
 * <p>
 * 请假表
 */
@TableName("leave")
public class Leave {

    @TableId
    private Integer id;
    // 员工编号
    private Integer employeeNumber;
    // 部门编号
    private Integer departmentNumber;
    // 起始时间
    private Date startTime;
    // 结束时间
    private Date endTime;
    // 请假天数
    private String days;
    // 请假理由
    private String reason;
    // 请假类型 '事假', '病假'
    private String type;
    // 经理
    private String manager;
    // 批准状态 '已批准', '未批准'
    private String status;
    // 备注
    private String notes;
}
