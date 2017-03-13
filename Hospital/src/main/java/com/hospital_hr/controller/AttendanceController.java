package com.hospital_hr.controller;

import com.hospital_hr.entity.Attendance;
import com.hospital_hr.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午10:29 on 17/2/12.
 */
@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    /**
     * 签到
     *
     * @param employeeNumber
     * @return
     */
    @RequestMapping("/addStart.do")
    public String addStart(Integer employeeNumber) {
        attendanceService.addStart(employeeNumber);
        return "welcome";
    }

    /**
     * 签退
     *
     * @param employeeNumber
     * @return
     */
    @RequestMapping("/addEnd.do")
    public String addEnd(Integer employeeNumber) {
        attendanceService.addEnd(employeeNumber);
        return "welcome";
    }

    /**
     * 查询所有员工考勤记录
     *
     * @param model
     * @return
     */
    @RequestMapping("/list.do")
    public String selectList(Model model) {
        List<Attendance> attendanceList = attendanceService.selectList();
        model.addAttribute("aList", attendanceList);
        return "admin/attendance_lsit";
    }

}
