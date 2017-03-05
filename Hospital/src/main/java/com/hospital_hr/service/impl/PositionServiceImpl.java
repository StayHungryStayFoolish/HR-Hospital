package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.Position;
import com.hospital_hr.mapper.PositionMapper;
import com.hospital_hr.service.PositionService;
import org.springframework.stereotype.Service;

/**
 * Created by bonismo@hotmail.com
 * 下午11:28 on 17/3/5.
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService {

    /**
     * 根据职称编号查询
     *
     * @param positionNumber
     * @return
     */
    @Override
    public Position selectByNumber(Integer positionNumber) {
        return baseMapper.selectByNumber(positionNumber);
    }

    /**
     * 分页查询所有职称信息
     *
     * @param page
     * @return
     */
    @Override
    public Page<Position> selectListByPage(int page) {
        Page<Position> pageInfo = new Page<>(page, 5, "id");
        pageInfo.setAsc(false);
        pageInfo.setRecords(baseMapper.selectPage(pageInfo, null));
        return pageInfo;
    }
}
