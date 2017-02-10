package com.hospital_hr.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hospital_hr.entity.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午10:18 on 17/2/10.
 */
public interface AttendanceMapper extends BaseMapper<Attendance> {

    /**
     * 根据员工编号/时间查询考勤
     *
     * @param employeeNumber
     * @param day
     * @param timeType
     * @return
     */
    Attendance selectByNumber(@Param("employeeNumber") Integer employeeNumber,
                              @Param("day") Date day,
                              @Param("timeType") String timeType);
}
