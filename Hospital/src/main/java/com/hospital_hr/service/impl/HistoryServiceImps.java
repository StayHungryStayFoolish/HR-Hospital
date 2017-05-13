package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
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

    /**
     * 分页查询离退休员工档案
     *
     * @param page
     * @return
     */
    @Override
    public Page<History> selectRetireByPage(int page) {
        Page<History> pageInfo = new Page<>(page, 5, "id");
        pageInfo.setAsc(false);
        List<History> historyList = baseMapper.selectRetireByPage(pageInfo);
        for (History history : historyList) {
            setObject(history);
        }
        pageInfo.setRecords(historyList);
        return pageInfo;
    }

    /**
     * 根据 ID 查询员工档案
     *
     * @param id
     * @return
     */
    @Override
    public History selectHistory(Integer id) {
        History history = baseMapper.selectById(id);
        setObject(history);
        return history;
    }

    /**
     * 分页查询员工档案信息
     *
     * @param page
     * @return
     */
    @Override
    public Page<History> selectListByPage(int page) {
        Page<History> pageInfo = new Page<>(page, 5);
        pageInfo.setAsc(false);
        List<History> historyList = baseMapper.selectPage(pageInfo, null);
        for (History history : historyList) {
            setObject(history);
        }
        pageInfo.setRecords(historyList);
        return pageInfo;
    }

    /**
     * 根据员工编号查询档案
     *
     * @param employeeNumber
     * @return
     */
    @Override
    public History selectByNumber(Integer employeeNumber) {
        return baseMapper.selectByNumber(employeeNumber);
    }

    /**
     * 查询所有员工档案
     *
     * @return
     */
    @Override
    public List<History> selectList() {
        List<History> historyList = baseMapper.selectList(new EntityWrapper<>());
        for (History history : historyList) {
            setObject(history);
        }
        return historyList;
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
