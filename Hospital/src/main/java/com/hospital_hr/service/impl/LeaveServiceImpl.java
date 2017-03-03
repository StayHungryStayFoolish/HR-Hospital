package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.Department;
import com.hospital_hr.entity.Employee;
import com.hospital_hr.entity.Leave;
import com.hospital_hr.mapper.DepartmentMapper;
import com.hospital_hr.mapper.EmployeeMapper;
import com.hospital_hr.mapper.LeaveMapper;
import com.hospital_hr.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午6:59 on 17/3/3.
 */
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper, Leave> implements LeaveService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询所有请假记录
     *
     * @return
     */
    @Override
    public List<Leave> selectList() {
        List<Leave> leaveList = baseMapper.selectList(new EntityWrapper<Leave>().orderBy("start_time", false));
        for (Leave leave : leaveList) {
            setObject(leave);
        }
        return leaveList;
    }

    /**
     * 根据 ID 查询请假信息
     *
     * @param id
     * @return
     */
    @Override
    public Leave selectLeave(Integer id) {
        Leave leave = baseMapper.selectById(id);
        setObject(leave);
        return leave;
    }

    /**
     * 更改请假人的批准状态
     *
     * @param id
     */
    @Override
    public void updateStatus(Integer id) {
        Leave leave = baseMapper.selectById(id);
        leave.setStatus("已批准");
        baseMapper.updateById(leave);
    }

    @Override
    public Page<Leave> selectByEmployee(Integer employeeNumber, int page) {
        return null;
    }

    @Override
    public List<Leave> selectListByStatus(Integer departmentNumber, String status) {
        return null;
    }

    private Leave setObject(Leave leave) {

        Integer employeeNumber = leave.getEmployeeNumber();
        if (null != employeeNumber) {
            Employee employee = employeeMapper.selectByNumber(employeeNumber);
            leave.setEmployee(employee);
        } else {
            leave.setEmployee(null);
        }

        Integer departmentNumber = leave.getDepartmentNumber();
        if (null != departmentNumber) {
            Department department = departmentMapper.selectByNumber(departmentNumber);
            leave.setDepartment(department);
        } else {
            leave.setDepartment(null);
        }
        return leave;
    }
}
