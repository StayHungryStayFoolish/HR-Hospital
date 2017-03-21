package com.hospital_hr.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hospital_hr.entity.Position;
import com.hospital_hr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午10:22 on 17/3/21.
 */
@Controller
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    /**
     * 分页查询职称信息
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/listPage.do")
    public String selectListByPage(int page, Model model) {
        Page<Position> pageInfo = positionService.selectListByPage(page);
        model.addAttribute("page", pageInfo);
        return "admin/position_list";
    }

    /**
     * 准备添加职称信息 [只查询, 不操作]
     *
     * @param model
     * @return
     */
    @RequestMapping("/toAdd.do")
    public String toAdd(Model model) {
        List<Position> dList = positionService.selectList(new EntityWrapper<Position>()
                .orderBy("position_number", false));
        model.addAttribute("positionNumber", dList.get(0).getPositionNumber() + 1);
        return "admin/position_add";
    }

    /**
     * 添加职称信息
     *
     * @param position
     * @return
     */
    @RequestMapping("/add.do")
    public String add(Position position) {
        positionService.insert(position);
        return "forward:/position/listPage.do?page=1";
    }

    /**
     * 准备更新职称信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}/toUpdate.do")
    public String toUpdate(@PathVariable Integer id, Model model) {
        Position position = positionService.selectById(id);
        model.addAttribute("position", position);
        return "admin/position_update";
    }

    /**
     * 更新职称信息
     *
     * @param id
     * @param position
     * @return
     */
    @RequestMapping("/{id}/update.do")
    public String updateById(@PathVariable Integer id, Position position) {
        position.setId(id);
        positionService.updateById(position);
        return "forward:/position/listPage.do?page=1";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/{id}/delete.do")
    public String deleteById(@PathVariable Integer id) {
        positionService.deleteById(id);
        return "forward:/position/listPage.do?page=1";
    }
}
