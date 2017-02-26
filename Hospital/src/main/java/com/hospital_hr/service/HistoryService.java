package com.hospital_hr.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hospital_hr.entity.History;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午11:29 on 17/2/26.
 */
public interface HistoryService extends IService<History> {

    /**
     * 分页查询离退休员工
     *
     * @param page
     * @return
     */
    Page<History> selectRetireByPage(int page);

    /**
     * 根据 ID 查询员工档案
     *
     * @param id
     * @return
     */
    History selectHistory(Integer id);

    /**
     * 分页查询所有员工档案
     *
     * @param page
     * @return
     */
    Page<History> selectListByPage(int page);

    /**
     * 根据员工编号查询档案
     *
     * @param employeeNumber
     * @return
     */
    History selectByNumber(Integer employeeNumber);

    /**
     * 查询所有员工档案
     *
     * @return
     */
    List<History> selectList();
}
