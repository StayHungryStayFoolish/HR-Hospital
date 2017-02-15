package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.Employee;
import com.hospital_hr.mapper.*;
import com.hospital_hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午11:31 on 17/2/15.
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private HistoryMapper historyMapper;

    @Autowired
    private MoveMapper moveMapper;

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public Employee checkLogin(Integer employeeNumber, String password) {
        return null;
    }

    @Override
    public Page<Employee> selectListByPage(int page) {
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public Employee selectEmployee(Integer id) {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee, String status, String manager) {

    }

    @Override
    public void deleteEmployee(Integer id) {

    }

    @Override
    public Employee selectByNumber(Integer employeeNumber) {
        return null;
    }

    @Override
    public Page<Employee> search(String input, int page) {
        return null;
    }

    @Override
    public List<Employee> select(Integer employeeNumber, String password) {
        return null;
    }
}
