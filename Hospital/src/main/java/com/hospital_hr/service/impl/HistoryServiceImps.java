package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.Department;
import com.hospital_hr.entity.History;
import com.hospital_hr.entity.Position;
import com.hospital_hr.mapper.DepartmentMapper;
import com.hospital_hr.mapper.HistoryMapper;
import com.hospital_hr.mapper.PositionMapper;
import com.hospital_hr.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午9:58 on 17/2/28.
 */
@Service
public class HistoryServiceImps extends ServiceImpl<HistoryMapper, History> implements HistoryService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public Page<History> selectRetireByPage(int page) {
        return null;
    }

    @Override
    public History selectHistory(Integer id) {
        return null;
    }

    @Override
    public Page<History> selectListByPage(int page) {
        return null;
    }

    @Override
    public History selectByNumber(Integer employeeNumber) {
        return null;
    }

    @Override
    public List<History> selectList() {
        return null;
    }

    /**
     * 在 档案表中,要补全 部门信息,职称信息
     *
     * @param history
     * @return
     */
    private History setObject(History history) {
        Integer departmentNumber = history.getDepartmentNumber();
        if (null != departmentNumber) {
            Department department = departmentMapper.selectByNumber(departmentNumber);
            history.setDepartment(department);
        } else {
            history.setDepartment(null);
        }
        Integer positionNumber = history.getPositionNumber();
        if (null != positionNumber) {
            Position position = positionMapper.selectByNumber(positionNumber);
            history.setPosition(position);
        } else {
            history.setPosition(null);
        }
        return history;
    }
}
