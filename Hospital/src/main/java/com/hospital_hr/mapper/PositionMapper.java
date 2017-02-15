package com.hospital_hr.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hospital_hr.entity.Position;

/**
 * Created by bonismo@hotmail.com
 * 上午12:14 on 17/2/16.
 */
public interface PositionMapper extends BaseMapper<Position> {

    /**
     * 根据职称比好查询信息
     *
     * @param positionNumber
     * @return
     */
    Position selectByNumber(Integer positionNumber);
}
