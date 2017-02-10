package com.hospital_hr.service;

import com.baomidou.mybatisplus.service.IService;
import com.hospital_hr.entity.Attendance;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午10:34 on 17/2/10.
 */
public interface AttendanceService extends IService<Attendance> {

    /**
     * 根据员工号,加入上班记录
     *
     * @param employeeNumber
     */
    void addStart(Integer employeeNumber);

    /**
     * 根据员工号,更新下班记录
     *
     * @param employeeNumber
     */
    void addEnd(Integer employeeNumber);

    /**
     * 查询所有考勤记录
     *
     * @return
     */
    List<Attendance> selectList();

    /**
     * 根据员工号,查询考勤记录
     *
     * @param employeeNumber
     * @return
     */
    List<Attendance> selectByEmployee(Integer employeeNumber);
}
