package com.hospital_hr.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午11:32 on 17/1/22.
 * <p>
 * 考勤表
 */
@TableName("attendance")
public class Attendance extends Model<Attendance> implements Serializable {

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

    @TableField(exist = false)
    private Employee employee;

    @Override
    protected Serializable pkVal() {
        return this.id;
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

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStartType() {
        return startType;
    }

    public void setStartType(String startType) {
        this.startType = startType;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEndType() {
        return endType;
    }

    public void setEndType(String endType) {
        this.endType = endType;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", employeeNumber=" + employeeNumber +
                ", day=" + day +
                ", timeType='" + timeType + '\'' +
                ", startTime=" + startTime +
                ", startType='" + startType + '\'' +
                ", endTime=" + endTime +
                ", endType='" + endType + '\'' +
                ", workType='" + workType + '\'' +
                ", notes='" + notes + '\'' +
                ", employee=" + employee +
                '}';
    }
}
