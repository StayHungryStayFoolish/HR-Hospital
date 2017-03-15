package com.hospital_hr.controller;

import com.hospital_hr.entity.History;
import com.hospital_hr.service.EmployeeService;
import com.hospital_hr.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bonismo@hotmail.com
 * 下午9:55 on 17/3/15.
 */
@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/{id}/detail.do")
    public String selectHistory(@PathVariable Integer id, Model model) {
        History history = historyService.selectHistory(id);
        model.addAttribute("history", history);
        return "admin/history_detail";
    }

}
