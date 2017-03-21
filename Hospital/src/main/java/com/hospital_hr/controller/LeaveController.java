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


}
