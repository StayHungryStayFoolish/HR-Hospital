package com.hospital_hr.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hospital_hr.entity.Department;
import com.hospital_hr.entity.Employee;
import com.hospital_hr.entity.History;
import com.hospital_hr.entity.Position;
import com.hospital_hr.service.DepartmentService;
import com.hospital_hr.service.EmployeeService;
import com.hospital_hr.service.HistoryService;
import com.hospital_hr.service.PositionService;
import com.hospital_hr.uitl.MyTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

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
        System.out.println("进入  login 方法");
        return "login";
    }

    /**
     * 登录校验
     * 1.获取员工信息,并存储到 session 中
     * 2.根据权限级别,分别跳转不同页面
     *
     * @return
     */
    @RequestMapping("/checkLogin.do")
    public String checkLogin(HttpSession session, Employee employee) {
        System.out.println("进入方法");
        Employee empInfo = employeeService.checkLogin(employee.getEmployeeNumber(), employee.getPassword());
        // 如果员工信息不为空,通过员工信息获取职称表信息,然后获得职称级别,进而做权限判定
        if (null != empInfo) {
            // 将员工信息存入 session
            session.setAttribute("logged", empInfo);
            // 获取权限级别
            String level = empInfo.getPosition().getLevel();
            if ("人事部主任".equals(level)) {
//                return "redirect:/jsp/admin/index1.jsp";
                return "redirect:admin/index1";
//                return "admin/index1";
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
     * 注销
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        session.removeAttribute("logged");
        return "login";
    }

    /**
     * 分页查询所有员工
     * 跳转链接:人事页面功能
     * index1.jsp
     * index2.jso
     * 删除按妞，也需要重新查询，返回
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

    /**
     * 添加员工
     * employee_list.jsp [添加]页面跳转过来
     * 1.添加员工需要先查询到现在的员工编号(需要查询档案表记录),获取集合内的最后一个员工的编号,然后+1
     * 2.查询部门信息
     * 3.查询职称信息
     * 4.加入 model,携带属性跳转添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/toAdd.do")
    public String toAdd(Model model) {
        // 从档案表中,查询所有员工信息,并倒序排列
        List<History> historyList = historyService.selectList(new EntityWrapper<History>().orderBy("employee_number", false));
        // 获取最后一个员工信息(get(0),因为是倒序)的员工编号 +1 ,即添加的员工编号
        model.addAttribute("employeeNumber", historyList.get(0).getEmployeeNumber() + 1);
        // 获取所有部门信息
        List<Department> departmentList = departmentService.selectList(new EntityWrapper<Department>());
        model.addAttribute("dList", departmentList);
        // 获取所有职称信息
        List<Position> positionList = positionService.selectList(new EntityWrapper<Position>());
        model.addAttribute("pList", positionList);
        return "admin/employee_add";
    }

    /**
     * 添加员工信息
     * 注：字符串转换为日期存储
     * employee_add.jsp 表单跳转
     *
     * @param employee
     * @param date
     * @return
     */
    @RequestMapping("/add.do")
    public String add(Employee employee, String date) {
        employee.setBirthday(MyTimeUtil.stringDateParse(date));
        employeeService.addEmployee(employee);
        return "forward:/employee/listPage.do?page=1";
    }

    /**
     * 根据 ID 查看员工信息
     * employee_list.jsp [查看]按钮跳转过来
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}/detail.do")
    public String selectEmployee(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.selectEmployee(id);
        model.addAttribute("employee", employee);
        return "admin/employee_detail";
    }

    /**
     * 更新员工信息,此处制作查询，携带出去转到 employee_update.jsp 页面实际操作
     * employee_list.jsp [修改]按钮跳转
     * employee_detail.jsp [修改]按钮跳转
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}/toUpdate.do")
    public String toUpdate(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.selectById(id);
        model.addAttribute("employee", employee);
        List<Department> departmentList = departmentService.selectList(new EntityWrapper<>());
        model.addAttribute("dList", departmentList);
        List<Position> positionList = positionService.selectList(new EntityWrapper<>());
        model.addAttribute("pList", positionList);
        return "admin/employee_update";
    }

    /**
     * 更新员工信息
     * 1.需要设置操作人员信息（从 session 中获取当前登录人员信息）
     * 2.字符串日子转换为 Date 类型
     *
     * @param id
     * @param employee
     * @param date
     * @param status
     * @param session
     * @return
     */
    @RequestMapping("/{id}/update.do")
    public String updateById(@PathVariable Integer id, Employee employee, String date, String status, HttpSession session) {
        employee.setId(id);
        employee.setBirthday(MyTimeUtil.stringDateParse(date));
        Employee manager = (Employee) session.getAttribute("logged");
        employeeService.updateEmployee(employee, status, manager.getName());
        return "forward:/employee/listPage.do?page=1";
    }

    /**
     * 根据 ID 删除员工信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/{id}/delete.do")
    public String deleteById(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "forward:/employee/listPage.do?page=1";
    }

    /**
     * 查看个人信息
     * index*.jsp 页面查看个人信息
     *
     * @return
     */
    @RequestMapping("/oneself/{id}/detail.do")
    public String selectEmployeeOneself(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.selectEmployee(id);
        model.addAttribute("employee", employee);
        return "admin/oneself_detail";
    }

    @RequestMapping("/oneself/{id}/toUpdate.do")
    public String toUpdateOneself(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.selectById(id);
        model.addAttribute("employee", employee);
        return "admin/oneself_update";
    }
}
