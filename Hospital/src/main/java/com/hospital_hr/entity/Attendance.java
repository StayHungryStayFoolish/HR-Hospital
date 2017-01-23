package com.hospital_hr.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午11:32 on 17/1/22.
 *
 * 考勤表
 */
@TableName("attendance")
public class Attendance extends Model<Attendance> implements Serializable{

    @TableId
    private Integer id;
    // 员工编号
    private Integer employeeNumber;
    // 日期
    private Date day;
    // 上班状态 '上午', '下午', '加班'
    private String timeType;
    // 上班时间
    private Date startTime;
    // 上班考勤状态 '正常', '迟到', '未签到'
    private String startType;
    // 下班时间
    private Date endTime;
    // 下班考勤状态 '正常', '早退', '未签到'
    private String endType;
    // 工作状态 上班', '请假'
    private String workType;
    // 日志
    private String notes;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
