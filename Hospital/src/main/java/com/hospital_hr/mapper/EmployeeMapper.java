package com.hospital_hr.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hospital_hr.entity.Employee;
import org.apache.ibatis.annotations.Param;

/**
 * Created by bonismo@hotmail.com
 * 下午10:41 on 17/2/10.
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 根据员工编号/密码登录验证
     * @param employeeNumber
     * @param password
     * @return
     */
    Employee checkLogin(@Param("employeeNumber") Integer employeeNumber,
                        @Param("password") String password);

    /**
     * 根据员工编号查询信息
     * @param employeeNumber
     * @return
     */
    Employee selectByNumber(Integer employeeNumber);
}
