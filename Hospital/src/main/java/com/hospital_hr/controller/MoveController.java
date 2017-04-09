package com.hospital_hr.controller;

import com.hospital_hr.entity.Move;
import com.hospital_hr.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午10:38 on 17/3/21.
 */
@Controller
@RequestMapping("/move")
public class MoveController {

    @Autowired
    private MoveService moveService;

    @RequestMapping("/list.do")
    public String selectList(Model model) {
        List<Move> moveList = moveService.selectList();
        model.addAttribute("mList", moveList);
        return "admin/move_list";
    }

}
