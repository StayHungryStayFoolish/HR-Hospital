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
     * 跳转链接:人事页面功能
     * index1.jsp
     * index2.jso
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
     * employee_list.jsp 页面跳转过来
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
        return "admin/employee_add";
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
}
