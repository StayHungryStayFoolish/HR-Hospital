package com.hospital_hr.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.hospital_hr.entity.History;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 上午12:01 on 17/2/16.
 */
public interface HistoryMapper extends BaseMapper<History> {

    /**
     * 分页查询离职员工信息
     *
     * @param page
     * @return
     */
    List<History> selectRetireByPage(Pagination page);

    /**
     * 根据员工编号查询信息
     *
     * @param employeeNumber
     * @return
     */
    History selectByNumber(Integer employeeNumber);
}
