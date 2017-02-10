package com.hospital_hr.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hospital_hr.entity.Employee;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午11:22 on 17/2/10.
 */
public interface EmployeeService extends IService<Employee> {

    /**
     * 登录校验
     *
     * @param employeeNumber
     * @param password
     * @return
     */
    Employee checkLogin(Integer employeeNumber, String password);

    /**
     * 分页查询所有员工
     *
     * @param page
     * @return
     */
    Page<Employee> selectListByPage(int page);

    /**
     * 添加员工,并同时添加到员工表和档案表
     *
     * @param employee
     */
    void addEmployee(Employee employee);

    /**
     * 查询员工信息
     *
     * @param id
     * @return
     */
    Employee selectEmployee(Integer id);

    /**
     * 更新员工信息
     *
     * @param employee
     * @param status
     * @param manager
     */
    void updateEmployee(Employee employee, String status, String manager);

    /**
     * 删除员工信息
     *
     * @param id
     */
    void deleteEmployee(Integer id);

    /**
     * 根据员工编号查询信息
     *
     * @param employeeNumber
     * @return
     */
    Employee selectByNumber(Integer employeeNumber);

    /**
     * 根据条件查询员工信息
     *
     * @param input
     * @param page
     * @return
     */
    Page<Employee> search(String input, int page);

    /**
     * 根据员工编号/密码查询
     *
     * @param employeeNumber
     * @param password
     * @return
     */
    List<Employee> select(Integer employeeNumber, String password);
}
