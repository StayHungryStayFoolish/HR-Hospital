package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.Attendance;
import com.hospital_hr.mapper.AttendanceMapper;
import com.hospital_hr.mapper.EmployeeMapper;
import com.hospital_hr.service.AttendanceService;
import com.hospital_hr.uitl.MyConstant;
import com.hospital_hr.uitl.MyTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午10:59 on 17/2/10.
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> implements AttendanceService {

    @Autowired
    private EmployeeMapper employeeMapper;

    Date amTime = MyTimeUtil.stringTimeParse(MyConstant.AMTime);
    Date amStartTime = MyTimeUtil.stringTimeParse(MyConstant.AMStartTime);
    Date amEndTime = MyTimeUtil.stringTimeParse(MyConstant.AMEndTime);
    Date pmTime = MyTimeUtil.stringTimeParse(MyConstant.PMTime);
    Date pmStartTime = MyTimeUtil.stringTimeParse(MyConstant.PMStartTime);
    Date pmEndTime = MyTimeUtil.stringTimeParse(MyConstant.PMEndTime);
    Date ovTime = MyTimeUtil.stringTimeParse(MyConstant.OVTime);
    Date ovStartTime = MyTimeUtil.stringTimeParse(MyConstant.OVStartTime);
    Date ovEndTime = MyTimeUtil.stringTimeParse(MyConstant.OVEndTime);


    @Override
    public void addStart(Integer employeeNumber) {
        // 获取当前时间
        Date nowTime = MyTimeUtil.nowTime();
        // 获取当前日期
        Date nowDate = MyTimeUtil.nowData();

        Attendance attendance = new Attendance();
        attendance.setEmployeeNumber(employeeNumber);
        attendance.setDay(nowDate);
        attendance.setStartTime(nowTime);

        if (nowTime.after(amTime) && nowDate.before(amEndTime)) {
            Attendance attInfo = baseMapper.selectByNumber(employeeNumber, nowDate, "上午");
            if (null == attInfo) {
                attendance.setTimeType("上午");
                if (nowTime.before(amStartTime)) {
                    attendance.setTimeType("正常");
                } else {
                    attendance.setStartType("迟到");
                }
                baseMapper.insert(attendance);
            }
        } else if (nowTime.after(pmTime) && nowTime.before(pmEndTime)) {
            Attendance attInfo = baseMapper.selectByNumber(employeeNumber, nowDate, "下午");
        }
    }

    @Override
    public void addEnd(Integer employeeNumber) {

    }

    @Override
    public List<Attendance> selectList() {
        return null;
    }

    @Override
    public List<Attendance> selectByEmployee(Integer employeeNumber) {
        return null;
    }
}
