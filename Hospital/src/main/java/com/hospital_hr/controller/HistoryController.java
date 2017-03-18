package com.hospital_hr.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.hospital_hr.entity.Employee;
import com.hospital_hr.entity.History;
import com.hospital_hr.service.EmployeeService;
import com.hospital_hr.service.HistoryService;
import com.hospital_hr.uitl.MyTimeUtil;
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

    /**
     * 更改离退休档案信息, 并跳转到分页查询页面
     *
     * @param id
     * @param history
     * @param date
     * @return
     */
    @RequestMapping("/{id}/updateRetire.do")
    public String updateRetire(@PathVariable Integer id, History history, String date) {
        history.setId(id);
        history.setBirthday(MyTimeUtil.stringDateParse(date));
        historyService.updateById(history);
        return "forward:/history/retireListPage.do?page=1";
    }

    /**
     * 分页显示离退休档案记录
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/retireListPage.do")
    public String selectRetireByPage(int page, Model model) {
        Page<History> pageInfo = historyService.selectRetireByPage(page);
        model.addAttribute("page", pageInfo);
        return "admin/retire_list";
    }

    /**
     * 分页查询档案信息
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/listPage.do")
    public String selectListByPage(int page, Model model) {
        Page<History> pageInfo = historyService.selectListByPage(page);
        model.addAttribute("page", pageInfo);
        return "admin/history_list";
    }

    /**
     * 根据 ID 更改档案信息
     *
     * @param id
     * @param history
     * @param date
     * @return
     */
    @RequestMapping("/{id}/update.do")
    public String updateById(@PathVariable Integer id, History history, String date) {
        history.setId(id);
        history.setBirthday(MyTimeUtil.stringDateParse(date));
        historyService.updateById(history);
        return "forward:/history/listPage.do?pageNo=1";
    }
}
