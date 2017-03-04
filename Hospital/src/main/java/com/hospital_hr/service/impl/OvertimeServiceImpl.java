package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.Overtime;
import com.hospital_hr.mapper.DepartmentMapper;
import com.hospital_hr.mapper.EmployeeMapper;
import com.hospital_hr.mapper.OvertimeMapper;
import com.hospital_hr.service.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by bonismo@hotmail.com
 * 下午10:35 on 17/3/4.
 */
public class OvertimeServiceImpl extends ServiceImpl<OvertimeMapper, Overtime> implements OvertimeService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public Page<Overtime> selectListByPage(int page) {
        return null;
    }

    @Override
    public Page<Overtime> selectByEmployee(int page, Integer employeeNumber) {
        return null;
    }
}
