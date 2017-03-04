package com.hospital_hr.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hospital_hr.entity.Overtime;

/**
 * Created by bonismo@hotmail.com
 * 下午10:32 on 17/3/4.
 */
public interface OvertimeService extends IService<Overtime> {

    /**
     * 分页查询所有加班记录
     *
     * @param page
     * @return
     */
    Page<Overtime> selectListByPage(int page);

    /**
     * 根据员工编号查询所有加班记录,并分页显示
     *
     * @param page
     * @param employeeNumber
     * @return
     */
    Page<Overtime> selectByEmployee(int page, Integer employeeNumber);
}
