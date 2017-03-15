package com.hospital_hr.controller;

import com.hospital_hr.entity.Employee;
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

    /**
     * 员工根据自神 ID 查询档案信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}/detail.do")
    public String selectHistory(@PathVariable Integer id, Model model) {
        History history = historyService.selectHistory(id);
        model.addAttribute("history", history);
        return "admin/history_detail";
    }

    /**
     * 更改档案信息 [只查询数据，不操作]
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}/toUpdate.do")
    public String toUpdate(@PathVariable Integer id, Model model) {
        History history = historyService.selectHistory(id);
        if (history.getStatus().equals("在职")) {
            Employee employee = employeeService.selectByNumber(history.getEmployeeNumber());
            return "forward:/employee/" + employee.getId() + "/toUpdate.do";
        } else {
            model.addAttribute("history", history);
            return "admin/history_update";
        }
    }

}
