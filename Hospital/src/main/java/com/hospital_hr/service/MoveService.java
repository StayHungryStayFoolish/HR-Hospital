package com.hospital_hr.service;

import com.baomidou.mybatisplus.service.IService;
import com.hospital_hr.entity.Move;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午10:19 on 17/3/3.
 */
public interface MoveService extends IService<Move> {

    /**
     * 查询所有调动记录
     *
     * @return
     */
    List<Move> selectList();
}
