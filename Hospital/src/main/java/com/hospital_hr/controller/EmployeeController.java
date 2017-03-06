package com.hospital_hr.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.hospital_hr.entity.Employee;
import com.hospital_hr.service.DepartmentService;
import com.hospital_hr.service.EmployeeService;
import com.hospital_hr.service.HistoryService;
import com.hospital_hr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private HistoryService historyService;

    /**
     * 跳转到签到页面
     *
     * @return
     */
    @RequestMapping("/welcome.do")
    public String welcome() {
        return "welcome";
    }

    /**
     * 跳转登录界面
     *
     * @return
     */
    @RequestMapping("/login.do")
    public String login() {
        return "login";
    }

    /**
     * 登录校验
     * 1.获取员工信息,并存储到 session 中
     * 2.根据权限级别,分别跳转不同页面
     *
     * @return
     */
    public String checkLogin(HttpSession session, Employee employee) {
        Employee empInfo = employeeService.checkLogin(employee.getEmployeeNumber(), employee.getPassword());
        // 如果员工信息不为空,通过员工信息获取职称表信息,然后获得职称级别,进而做权限判定
        if (null != empInfo) {
            session.setAttribute("logged", empInfo);
            // 获取权限级别
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

    /**
     * 分页查询所有员工
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/listPage.do")
    private String selectList(int page, Model model) {
        Page<Employee> pageInfo = employeeService.selectListByPage(page);
        model.addAttribute("page", pageInfo);
        return "admin/employee_list";
    }

}
