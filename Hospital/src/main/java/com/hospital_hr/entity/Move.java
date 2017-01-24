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

    public Integer getAgo() {
        return ago;
    }

    public void setAgo(Integer ago) {
        this.ago = ago;
    }

    public Integer getAfter() {
        return after;
    }

    public void setAfter(Integer after) {
        this.after = after;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment1() {
        return department1;
    }

    public void setDepartment1(Department department1) {
        this.department1 = department1;
    }

    public Department getDepartment2() {
        return department2;
    }

    public void setDepartment2(Department department2) {
        this.department2 = department2;
    }

    @Override
    public String toString() {
        return "Move{" +
                "id=" + id +
                ", employeeNumber=" + employeeNumber +
                ", ago=" + ago +
                ", after=" + after +
                ", time=" + time +
                ", manager='" + manager + '\'' +
                ", notes='" + notes + '\'' +
                ", employee=" + employee +
                ", department1=" + department1 +
                ", department2=" + department2 +
                '}';
    }
}
