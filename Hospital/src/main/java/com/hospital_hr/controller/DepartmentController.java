package com.hospital_hr.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hospital_hr.entity.Department;
import com.hospital_hr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
     * 添加部门,先获取部门编号 [只查询，不操作]
     * 1.需要查询到所有的部门信息
     * 2.orderBy("columnName",boolean isAsc) false 时，倒序，使用 get(0) 获取最后一个部门，获取部门编号 + 1 == 新增部门编号
     *
     * @param model
     * @return
     */
    @RequestMapping("/toAdd.do")
    public String toAdd(Model model) {
        List<Department> departmentList = departmentService.selectList(
                new EntityWrapper<Department>().orderBy("department_number", false));
        model.addAttribute("departmentNumber", departmentList.get(0).getDepartmentNumber() + 1);
        return "admin/department_add";
    }

    /**
     * 添加部门 [操作]
     *
     * @param department
     * @return
     */
    @RequestMapping("/add.do")
    public String add(Department department) {
        departmentService.insert(department);
        return "forward:/department/listPage.do?page=1";
    }


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

    /**
     * 更改部门信息 [只获取信息,不操作]
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}/toUpdate.do")
    public String toUpdate(@PathVariable Integer id, Model model) {
        Department department = departmentService.selectById(id);
        model.addAttribute("department", department);
        return "admin/department_update";
    }

    /**
     * 更改部门信息, 并返回分页查询页面
     *
     * @param id
     * @param department
     * @return
     */
    @RequestMapping("/{id}/update.do")
    public String updateById(@PathVariable Integer id, Department department) {
        department.setId(id);
        departmentService.updateById(department);
        return "/department/listPage.do?page=1";
    }

    /**
     * 删除部门信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/{id}/delete.do")
    public String deleteById(@PathVariable Integer id) {
        departmentService.deleteById(id);
        return "/department/listPage.do?page=1";
    }
}
