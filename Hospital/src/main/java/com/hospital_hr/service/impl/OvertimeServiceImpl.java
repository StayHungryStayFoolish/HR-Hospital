package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.Department;
import com.hospital_hr.entity.Employee;
import com.hospital_hr.entity.Overtime;
import com.hospital_hr.mapper.DepartmentMapper;
import com.hospital_hr.mapper.EmployeeMapper;
import com.hospital_hr.mapper.OvertimeMapper;
import com.hospital_hr.service.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Id;
import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午10:35 on 17/3/4.
 */
public class OvertimeServiceImpl extends ServiceImpl<OvertimeMapper, Overtime> implements OvertimeService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;


    /**
     * 分页查询所有加班记录
     *
     * @param page
     * @return
     */
    @Override
    public Page<Overtime> selectListByPage(int page) {
        Page<Overtime> pageInfo = new Page<>(page, 5, "id");
        pageInfo.setAsc(false);
        List<Overtime> overtimeList = baseMapper.selectPage(pageInfo, null);
        for (Overtime overtime : overtimeList) {
            setObject(overtime);
        }
        pageInfo.setRecords(overtimeList);
        return pageInfo;
    }

    /**
     * 根据员工编号,查询所有加班记录,并分页显示
     *
     * @param page
     * @param employeeNumber
     * @return
     */
    @Override
    public Page<Overtime> selectByEmployee(int page, Integer employeeNumber) {
        Page<Overtime> pageInfo = new Page<>(page, 5, "id");
        pageInfo.setAsc(false);
        List<Overtime> overtimeList = baseMapper.selectPage(pageInfo, new EntityWrapper<Overtime>()
                .eq("employee_number", employeeNumber)
                .orderBy("id", false));
        for (Overtime overtime : overtimeList) {
            setObject(overtime);
        }
        pageInfo.setRecords(overtimeList);
        return pageInfo;
    }

    /**
     * 加班表补全 部门信息/员工信息
     *
     * @param overtime
     * @return
     */
    private Overtime setObject(Overtime overtime) {
        Integer departmentNumber = overtime.getDepartmentNumber();
        if (null != departmentNumber) {
            Department department = departmentMapper.selectByNumber(departmentNumber);
            overtime.setDepartment(department);
        } else {
            overtime.setDepartment(null);
        }

        Integer employeeNumber = overtime.getEmployeeNumber();
        if (null != employeeNumber) {
            Employee employee = employeeMapper.selectByNumber(employeeNumber);
            overtime.setEmployee(employee);
        } else {
            overtime.setEmployee(null);
        }
        return overtime;
    }
}
