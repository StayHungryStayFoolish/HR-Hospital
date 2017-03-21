package com.hospital_hr.controller;

import com.hospital_hr.service.DepartmentService;
import com.hospital_hr.service.EmployeeService;
import com.hospital_hr.service.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bonismo@hotmail.com
 * 下午11:52 on 17/3/21.
 */
@Controller
@RequestMapping("/overtime")
public class OvertimeController {

    @Autowired
    private OvertimeService overtimeService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

}
