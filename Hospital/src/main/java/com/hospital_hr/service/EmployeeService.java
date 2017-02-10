package com.hospital_hr.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hospital_hr.entity.Employee;

/**
 * Created by bonismo@hotmail.com
 * 下午11:22 on 17/2/10.
 */
public interface EmployeeService extends IService<Employee> {

    Employee checkLogin(Integer employeeNumber,String password);

    Page<Employee> selectListByPage(int page);

    void addEmployee(Employee employee);

    Employee selectEmployee(Integer id);

    void updateEmployee(Employee employee, String status, String manager);

    void deleteEmployee(Integer id);

}
