package com.hospital_hr.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hospital_hr.entity.Department;
import com.hospital_hr.entity.Employee;
import com.hospital_hr.entity.Overtime;
import com.hospital_hr.service.DepartmentService;
import com.hospital_hr.service.EmployeeService;
import com.hospital_hr.service.OvertimeService;
import com.hospital_hr.uitl.MyTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    /**
     * 分页查询加班记录
     *
     * @param model
     * @param page
     * @return
     */
    @RequestMapping("/listPage.do")
    public String selectListByPage(int page, Model model) {
        Page<Overtime> pageInfo = overtimeService.selectListByPage(page);
        model.addAttribute("page", pageInfo);
        return "admin/overtime_list";
    }

    /**
     * 安排加班 [只查询,不操作]
     *
     * @param model
     * @return
     */
    @RequestMapping("/toAdd.do")
    public String toAdd(Model model) {
        //查询出所有的部门
        List<Department> dList = departmentService.selectList(new EntityWrapper<Department>());
        model.addAttribute("dList", dList);
        //查询出所有的员工
        List<Employee> eList = employeeService.selectList(new EntityWrapper<Employee>());
        model.addAttribute("eList", eList);
        return "admin/overtime_add";
    }

    /**
     * 安排加班 [操作]
     *
     * @param overtime
     * @param date
     * @return
     */
    @RequestMapping("/add.do")
    public String add(Overtime overtime, String date) {
        overtime.setDay(MyTimeUtil.stringDateParse(date));
        overtimeService.insert(overtime);
        return "forward:/overtime/listPage.do?page=1";
    }
}
