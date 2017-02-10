package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.Attendance;
import com.hospital_hr.mapper.AttendanceMapper;
import com.hospital_hr.service.AttendanceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午10:59 on 17/2/10.
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> implements AttendanceService {


    @Override
    public void addStart(Integer employeeNumber) {

    }

    @Override
    public void addEnd(Integer employeeNumber) {

    }

    @Override
    public List<Attendance> selectList() {
        return null;
    }

    @Override
    public List<Attendance> selectByEmployee(Integer employeeNumber) {
        return null;
    }
}
