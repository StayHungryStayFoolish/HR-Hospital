package com.hospital_hr.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hospital_hr.entity.Leave;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午10:40 on 17/2/28.
 */
public interface LeaveService extends IService<Leave> {

    /**
     * 查询所有请假记录
     *
     * @return
     */
    List<Leave> selectList();

    /**
     * 根据 ID 查询请假记录
     *
     * @param id
     * @return
     */
    Leave selectLeave(Integer id);

    /**
     * 更改请假人的批准状态
     *
     * @param id
     */
    void updateStatus(Integer id);

    /**
     * 根据 员工编号,查询一个人的所有请假记录
     *
     * @param employeeNumber
     * @param page
     * @return
     */
    Page<Leave> selectByEmployee(Integer employeeNumber, int page);

    /**
     * 根据批准状态查询所有请假记录
     *
     * @param departmentNumber
     * @param status
     * @return
     */
    List<Leave> selectListByStatus(Integer departmentNumber, String status);

}
