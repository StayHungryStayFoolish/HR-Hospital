package com.hospital_hr.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hospital_hr.entity.Department;

/**
 * Created by bonismo@hotmail.com
 * 下午10:16 on 17/2/25.
 */
public interface DepartmentService extends IService<Department> {

    /**
     * 根据部门编号查询信息
     *
     * @param departmentNumber
     * @return
     */
    Department selectByNumber(Integer departmentNumber);

    /**
     * 分页查询所有部门
     *
     * @param page
     * @return
     */
    Page<Department> selectListPage(int page);
}
