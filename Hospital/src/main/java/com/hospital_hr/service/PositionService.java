package com.hospital_hr.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hospital_hr.entity.Position;

/**
 * Created by bonismo@hotmail.com
 * 下午11:11 on 17/3/5.
 */
public interface PositionService extends IService<Position> {

    /**
     * 根据职称编号查询信息
     *
     * @param positionNumber
     * @return
     */
    Position selectByNumber(Integer positionNumber);

    /**
     * 分页查询所有职称信息
     *
     * @param page
     * @return
     */
    Page<Position> selectListByPage(int page);

}
