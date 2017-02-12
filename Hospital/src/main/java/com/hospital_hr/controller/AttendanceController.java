package com.hospital_hr.controller;

import com.hospital_hr.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bonismo@hotmail.com
 * 下午10:29 on 17/2/12.
 */
@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("index")
    public String index() {
        System.out.println("进入 index 方法");
        return "redirect:/jsp/index.jsp";
    }

}
