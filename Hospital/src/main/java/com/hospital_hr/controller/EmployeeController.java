package com.hospital_hr.controller;

import com.hospital_hr.entity.Employee;
import com.hospital_hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by bonismo@hotmail.com
 * 下午11:12 on 17/2/22.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 跳转登录界面
     * @return
     */
    @RequestMapping("/login.do")
    public String login() {
        return "login";
    }

    /**
     * @return
     */
    public String checkLogin(HttpSession session, Employee employee) {
        Employee empInfo = employeeService.checkLogin(employee.getEmployeeNumber(), employee.getPassword());
        if (null != empInfo) {
            session.setAttribute("logged", empInfo);
            String level = empInfo.getPosition().getLevel();
            if ("人事部主任".equals(level)) {
                return "admin/index1";
            } else if ("人事部员工".equals(level)) {
                return "admin/index2";
            } else if ("部门主任".equals(level)) {
                return "admin/index3";
            } else {
                return "admin/index4";
            }
        } else {
            return "login";
        }
    }
}
