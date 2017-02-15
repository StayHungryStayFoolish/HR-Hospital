package com.hospital_hr.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hospital_hr.entity.Department;

/**
 * Created by bonismo@hotmail.com
 * 下午11:34 on 17/2/15.
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 根据部门编号查询信息
     *
     * @param departmentNumber
     * @return
     */
    Department selectByNumber(Integer departmentNumber);
}
