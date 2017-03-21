package com.hospital_hr.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.hospital_hr.entity.Employee;
import com.hospital_hr.entity.Leave;
import com.hospital_hr.service.LeaveService;
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
 * 下午9:49 on 17/3/21.
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    /**
     * 查询所有请假记录
     *
     * @param model
     * @return
     */
    @RequestMapping("/list.do")
    public String selectList(Model model) {
        List<Leave> list = leaveService.selectList();
        model.addAttribute("list", list);
        return "admin/leave_list";
    }

    /**
     * 查询本人请假记录
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}/detail.do")
    public String selectLeave(@PathVariable Integer id, Model model) {
        Leave leave = leaveService.selectLeave(id);
        model.addAttribute("leave", leave);
        return "admin/leave_detail";
    }

    /**
     * 批准员工请假，然后继续返回未批转页面
     * updateStatus(). service 层已设置为 批准状态
     *
     * @param id
     * @return
     */
    @RequestMapping("/{id}/update.do")
    public String updateStatus(@PathVariable Integer id) {
        leaveService.updateStatus(id);
        return "forward:/leave/notlist.do";
    }

    /**
     * 申请请假
     *
     * @return
     */
    @RequestMapping("/toAdd.do")
    public String toAdd() {
        return "admin/leave_add";
    }

    /**
     * 填写请假表单
     *
     * @param employeeNumber
     * @param leave
     * @param start
     * @param end
     * @return
     */
    @RequestMapping("/add.do")
    public String add(Integer employeeNumber, Leave leave, String start, String end) {
        leave.setEmployeeNumber(employeeNumber);
        leave.setStartTime(MyTimeUtil.stringDateParse(start));
        leave.setEndTime(MyTimeUtil.stringDateParse(end));
        leaveService.insert(leave);
        return "forward:/employee/welcome.do";
    }


    /**
     * 查询未准假记录
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/notlist.do")
    public String selectNotList(Model model, HttpSession session) {
        //获取登录用户的信息
        Employee employee = (Employee) session.getAttribute("logged");
        List<Leave> list = leaveService.selectListByStatus(employee.getDepartmentNumber(), "未批准");
        model.addAttribute("list", list);
        return "admin/leave_notlist";
    }


}
