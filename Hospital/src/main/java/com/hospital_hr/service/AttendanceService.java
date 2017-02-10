package com.hospital_hr.service;

import com.baomidou.mybatisplus.service.IService;
import com.hospital_hr.entity.Attendance;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午10:34 on 17/2/10.
 */
public interface AttendanceService extends IService<Attendance> {

    void addStart(Integer employeeNumber);

    void addEnd(Integer employeeNumber);

    List<Attendance> selectList();

    List<Attendance> selectByEmployee(Integer employeeNumber);
}
