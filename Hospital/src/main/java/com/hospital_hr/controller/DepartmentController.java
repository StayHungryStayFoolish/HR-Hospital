package com.hospital_hr.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.hospital_hr.entity.Department;
import com.hospital_hr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bonismo@hotmail.com
 * 下午10:39 on 17/3/14.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 分页查询部门信息
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/listPage.do")
    public String selectListByPage(int page, Model model) {
        Page<Department> pageInfo = departmentService.selectListPage(page);
        model.addAttribute("page", pageInfo);
        return "admin/department_list";
    }
}
