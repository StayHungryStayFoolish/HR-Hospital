package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.Attendance;
import com.hospital_hr.entity.Employee;
import com.hospital_hr.mapper.AttendanceMapper;
import com.hospital_hr.mapper.EmployeeMapper;
import com.hospital_hr.service.AttendanceService;
import com.hospital_hr.uitl.MyConstant;
import com.hospital_hr.uitl.MyTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
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


    /**
     * 添加上班签到记录
     * 1.判断当前时间节点 上午/下午/加班
     * 2.判断当前签到时间,并设置状态 正常/迟到
     * 3.添加状态
     *
     * @param employeeNumber
     */
    @Override
    public void addStart(Integer employeeNumber) {
        // 获取当前时间
        Date nowTime = MyTimeUtil.nowTime();
        // 获取当前日期
        Date nowDate = MyTimeUtil.nowData();
        // 创建考勤对象,记录签到员工号,日期,时间
        Attendance attendance = new Attendance();
        attendance.setEmployeeNumber(employeeNumber);
        attendance.setDay(nowDate);
        attendance.setStartTime(nowTime);

        // 判断当前时间在哪个节点

        // 判断当前时间是不是上午
        if (nowTime.after(amTime) && nowDate.before(amEndTime)) {
            Attendance attInfo = baseMapper.selectByNumber(employeeNumber, nowDate, "上午");
            // 如果当前未签到
            if (null == attInfo) {
                attendance.setTimeType("上午");
                // 判断时间点,是否符合规定时间
                if (nowTime.before(amStartTime)) {
                    attendance.setTimeType("正常");
                } else {
                    attendance.setStartType("迟到");
                }
                // 插入考勤记录
                baseMapper.insert(attendance);
            }
            // 判断当前时间是不是下午
        } else if (nowTime.after(pmTime) && nowTime.before(pmEndTime)) {
            Attendance attInfo = baseMapper.selectByNumber(employeeNumber, nowDate, "下午");
            // 如果当前未签到
            if (null == attInfo) {
                attendance.setTimeType("下午");
                // 判断当前时间,是否符合规定时间
                if (nowTime.before(pmStartTime)) {
                    attendance.setStartType("正常");
                } else {
                    attendance.setStartType("迟到");
                }
                baseMapper.insert(attendance);
            }
            // 判断当前时间是不是加班时间
        } else if (nowTime.after(ovTime) && nowTime.before(ovEndTime)) {
            Attendance attInfo = baseMapper.selectByNumber(employeeNumber, nowDate, "加班");
            if (null == attInfo) {
                attendance.setTimeType("加班");
                if (nowTime.before(ovStartTime)) {
                    attendance.setStartType("正常");
                } else {
                    attendance.setStartType("迟到");
                }
                baseMapper.insert(attendance);
            }
        }
    }

    /**
     * 添加下班签退记录
     * 1.判断当前时间节点  上午/下午/加班
     * 2.判断签退时间节点  正常/早退
     * 3.添加数据
     *
     * @param employeeNumber
     */
    @Override
    public void addEnd(Integer employeeNumber) {
        // 获取当前时间
        Date nowTime = MyTimeUtil.nowTime();
        // 获取当前日期
        Date nowDate = MyTimeUtil.nowData();
        if (nowTime.after(amStartTime) && nowTime.before(pmEndTime)) {
            Attendance attInfo = baseMapper.selectByNumber(employeeNumber, nowDate, "上午");
            if (null == attInfo.getEndTime()) {
                attInfo.setDay(nowTime);
                if (nowTime.after(amEndTime)) {
                    attInfo.setEndType("正常");
                } else {
                    attInfo.setEndType("早退");
                }
                baseMapper.insert(attInfo);
            }
        } else if (nowTime.after(pmStartTime) && nowTime.before(ovStartTime)) {
            Attendance attInfo = baseMapper.selectByNumber(employeeNumber, nowDate, "下午");
            if (null == attInfo.getEndTime()) {
                attInfo.setEndTime(nowTime);
                if (nowTime.after(pmEndTime)) {
                    attInfo.setEndType("正常");
                } else {
                    attInfo.setEndType("早退");
                }
                baseMapper.updateById(attInfo);
            }
        } else if (nowTime.after(ovStartTime)) {
            Attendance attInfo = baseMapper.selectByNumber(employeeNumber, nowDate, "加班");
            if (null == attInfo.getEndTime()) {
                attInfo.setEndTime(nowTime);
                if (nowTime.after(ovEndTime)) {
                    attInfo.setEndType("正常");
                } else {
                    attInfo.setEndType("早退");
                }
                baseMapper.updateById(attInfo);
            }
        }
    }

    @Override
    public List<Attendance> selectList() {
        List<Attendance> list = baseMapper.selectList(
                new EntityWrapper<Attendance>().orderBy("id", false));
        for (Attendance attendance : list) {
            Employee employee = employeeMapper.selectByNumber(attendance.getEmployeeNumber());
            attendance.setEmployee(employee);
        }
        return list;
    }

    @Override
    public List<Attendance> selectByEmployee(Integer employeeNumber) {
        return null;
    }
}
