package com.hospital_hr.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * Created by bonismo@hotmail.com
 * 下午11:30 on 17/1/23.
 * <p>
 * 职称表
 */
@TableName("position")
public class Position extends Model<Position> implements Serializable {

    @TableId
    private Integer id;
    // 职称编号
    private Integer positionNumber;
    // 职称名称
    private String name;
    // 职称级别
    private String level;
    // 备注
    private String notes;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
