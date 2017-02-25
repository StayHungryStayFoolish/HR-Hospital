package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.Department;
import com.hospital_hr.mapper.DepartmentMapper;
import com.hospital_hr.service.DepartmentService;
import org.springframework.stereotype.Service;

/**
 * Created by bonismo@hotmail.com
 * 下午10:20 on 17/2/25.
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    /**
     * 根据部门编号查询
     *
     * @param departmentNumber
     * @return
     */
    @Override
    public Department selectByNumber(Integer departmentNumber) {
        return baseMapper.selectByNumber(departmentNumber);
    }

    /**
     * 分页显示部门信息,倒序
     *
     * @param page
     * @return
     */
    @Override
    public Page<Department> selectListPage(int page) {
        Page<Department> pageInfo = new Page<>(page, 5, "id");
        // 默认true, 升序. false 倒序
        pageInfo.setAsc(false);
        // 分页信息设置记录
        pageInfo.setRecords(baseMapper.selectPage(pageInfo, null));
        return pageInfo;
    }
}
