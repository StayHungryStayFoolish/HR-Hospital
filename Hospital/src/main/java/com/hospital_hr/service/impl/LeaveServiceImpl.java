package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.Leave;
import com.hospital_hr.mapper.LeaveMapper;
import com.hospital_hr.service.LeaveService;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午6:59 on 17/3/3.
 */
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper,Leave> implements LeaveService{
    @Override
    public List<Leave> selectList() {
        return null;
    }

    @Override
    public Leave selectLeave(Integer id) {
        return null;
    }

    @Override
    public void updateStatus(Integer id) {

    }

    @Override
    public Page<Leave> selectByEmployee(Integer employeeNumber, int page) {
        return null;
    }

    @Override
    public List<Leave> selectListByStatus(Integer departmentNumber, String status) {
        return null;
    }
}
