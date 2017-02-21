package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.Department;
import com.hospital_hr.entity.Employee;
import com.hospital_hr.entity.Position;
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

    /**
     * 登录校验
     *
     * @param employeeNumber
     * @param password
     * @return
     */
    @Override
    public Employee checkLogin(Integer employeeNumber, String password) {
        Employee employee = baseMapper.checkLogin(employeeNumber, password);
        if (null != employee) {
            setObject(employee);
        }
        return employee;
    }

    /**
     * 分页查询信息
     *
     * @param page
     * @return
     */
    @Override
    public Page<Employee> selectListByPage(int page) {
        Page<Employee> pageInfo = new Page<>(page, 5, "id");
        // 是否为升序排列,默认 true
        pageInfo.setAsc(false);
        List<Employee> employeeList = baseMapper.selectPage(pageInfo, null);
        for (Employee employee : employeeList) {
            setObject(employee);
        }
        // 将查询到的分页信息存储到记录里
        pageInfo.setRecords(employeeList);
        return pageInfo;
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

    /**
     * 将 Department/Position 信息补全到 Employee 中
     *
     * @param employee
     * @return
     */
    private Employee setObject(Employee employee) {
        // 从 Employee 中获取部们编号
        Integer departmentNumber = employee.getDepartmentNumber();
        // 根据部门编号查询获得部门信息
        Department department = departmentMapper.selectByNumber(departmentNumber);
        employee.setDepartment(department);

        // 从 Employee 中获取职称编号
        Integer positionNumber = employee.getPositionNumber();
        // 根据职称编号查询获得职称信息
        Position position = positionMapper.selectByNumber(positionNumber);
        employee.setPosition(position);

        return employee;
    }
}
