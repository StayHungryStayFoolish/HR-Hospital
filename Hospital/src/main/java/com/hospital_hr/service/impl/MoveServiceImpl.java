package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.Department;
import com.hospital_hr.entity.Employee;
import com.hospital_hr.entity.Move;
import com.hospital_hr.mapper.DepartmentMapper;
import com.hospital_hr.mapper.EmployeeMapper;
import com.hospital_hr.mapper.MoveMapper;
import com.hospital_hr.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午10:21 on 17/3/3.
 */
@Service
public class MoveServiceImpl extends ServiceImpl<MoveMapper,Move> implements MoveService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Move> selectList() {
        List<Move> moveList = baseMapper.selectList(new EntityWrapper<Move>().orderBy("id", false));
        for (Move move : moveList) {
            Employee employee = employeeMapper.selectByNumber(move.getEmployeeNumber());
            move.setEmployee(employee);

            Department departmentAgo = departmentMapper.selectByNumber(move.getAgo());
            move.setDepartment1(departmentAgo);

            Department departmentAfter = departmentMapper.selectByNumber(move.getAfter());
            move.setDepartment2(departmentAfter);

        }
        return moveList;
    }
}
