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
import org.springframework.web.bind.annotation.PathVariable;
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
        List<Department> departmentList = departmentService.selectList(new EntityWrapper<>());
        model.addAttribute("dList", departmentList);
        //查询出所有的员工
        List<Employee> employeeList = employeeService.selectList(new EntityWrapper<>());
        model.addAttribute("eList", employeeList);
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
        return "/overtime/listPage.do?page=1";
    }

    /**
     * 准备更新加班
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}/toUpdate.do")
    public String toUpdate(@PathVariable Integer id, Model model) {
        //查询出要修改的记录信息
        Overtime overtime = overtimeService.selectById(id);
        model.addAttribute("overtime", overtime);
        //查询出所有的部门
        List<Department> departmentList = departmentService.selectList(new EntityWrapper<>());
        model.addAttribute("dList", departmentList);
        //查询出所有的员工
        List<Employee> employeeList = employeeService.selectList(new EntityWrapper<>());
        model.addAttribute("eList", employeeList);
        return "admin/overtime_update";
    }

    /**
     * 更新加班
     *
     * @param id
     * @param date
     * @param overtime
     * @return
     */
    @RequestMapping("/{id}/update.do")
    public String updateById(@PathVariable Integer id, String date, Overtime overtime) {
        overtime.setId(id);
        overtime.setDay(MyTimeUtil.stringDateParse(date));
        overtimeService.updateById(overtime);
        return "/overtime/listPage.do?page=1";
    }

    /**
     * 删除加班
     *
     * @param id
     * @return
     */
    @RequestMapping("/{id}/delete.do")
    public String deleteById(@PathVariable Integer id) {
        overtimeService.deleteById(id);
        return "/overtime/listPage.do?page=1";
    }

    /**
     * 查询自己加班记录
     *
     * @param employeeNumber
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/{employeeNumber}/oneself.do")
    public String select(@PathVariable Integer employeeNumber, int page, Model model) {
        Page<Overtime> pageInfo = overtimeService.selectByEmployee(page, employeeNumber);
        model.addAttribute("page", pageInfo);
        return "admin/oneself_overtime";
    }
}
