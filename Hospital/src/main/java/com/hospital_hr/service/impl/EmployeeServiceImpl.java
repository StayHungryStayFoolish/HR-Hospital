package com.hospital_hr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hospital_hr.entity.*;
import com.hospital_hr.mapper.*;
import com.hospital_hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by bonismo@hotmail.com
 * 下午11:31 on 17/2/15.
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private HistoryMapper historyMapper;

    @Autowired
    private MoveMapper moveMapper;

    @Autowired
    private PositionMapper positionMapper;

    /**
     * 登录校验
     *
     * @param employeeNumber
     * @param password
     * @return
     */
    @Override
    public Employee checkLogin(Integer employeeNumber, String password) {
        Employee employee = baseMapper.checkLogin(employeeNumber, password);
        if (null != employee) {
            setObject(employee);
        }
        return employee;
    }

    /**
     * 分页查询信息
     *
     * @param page
     * @return
     */
    @Override
    public Page<Employee> selectListByPage(int page) {
        Page<Employee> pageInfo = new Page<>(page, 5, "id");
        // 是否为升序排列,默认 true
        pageInfo.setAsc(false);
        List<Employee> employeeList = baseMapper.selectPage(pageInfo, null);
        for (Employee employee : employeeList) {
            setObject(employee);
        }
        // 将查询到的分页信息存储到记录里
        pageInfo.setRecords(employeeList);
        return pageInfo;
    }

    /**
     * 添加员工信息
     * 1.补全员工信息(入职时间)
     * 2.同时添加到档案表
     * 注:因为是 DML 语句, 需要开启事务.
     * 使用 @Transactional 注解
     *
     * @param employee
     */
    @Transactional
    @Override
    public void addEmployee(Employee employee) {
        // 设置入职时间
        employee.setInTime(new Date());
        // 将员工信息加入数据库
        baseMapper.insert(employee);

        // 向档案库 History 加入记录
        History history = new History();
        history.setEmployeeNumber(employee.getEmployeeNumber());
        history.setName(employee.getName());
        history.setGender(employee.getGender());
        history.setBirthday(employee.getBirthday());
        history.setTelephone(employee.getTelephone());
        history.setEmail(employee.getEmail());
        history.setAddress(employee.getAddress());
        history.setPhoto(employee.getPhoto());
        history.setEducation(employee.getEducation());
        history.setInTime(employee.getInTime());
        history.setDepartmentNumber(employee.getDepartmentNumber());
        history.setPositionNumber(employee.getPositionNumber());
        history.setStatus("在职");
        history.setNotes(employee.getNotes());

        historyMapper.insert(history);
    }

    /**
     * 根据 ID 查询员工信息
     *
     * @param id
     * @return
     */
    @Override
    public Employee selectEmployee(Integer id) {
        Employee employee = baseMapper.selectById(id);
        setObject(employee);
        return employee;
    }

    /**
     * 更新员工信息
     * 1.判断员工是否在职
     * 2.在职补全当前信息,并判断是否有部门调动
     * 3.不在职,删除员工表信息,转存档案表,并更新信息
     * 注:注解方式开启事务
     *
     * @param employee
     * @param status
     * @param manager
     */
    @Transactional
    @Override
    public void updateEmployee(Employee employee, String status, String manager) {

        // 判断是否在职
        // 如果在职,当前状态未改变,补全信息
        if ("在职".equals(status)) {
            Employee empInfo = baseMapper.selectById(employee.getId());
            Move move = new Move();
            move.setEmployeeNumber(employee.getEmployeeNumber());
            move.setTime(new Date());
            move.setManager(manager);
            // 判断部门编号是否改变,如果改变,将更改前后的部门编号分别补全到员工调用表
            if (!employee.getDepartmentNumber().equals(empInfo.getDepartmentNumber())) {
                move.setAgo(empInfo.getDepartmentNumber());
                move.setAfter(employee.getDepartmentNumber());
                moveMapper.insert(move);
            }
            baseMapper.updateById(employee);
        } else {
            // 如果不在职,进入 else
            // 删除员工记录,将信息转存到档案表中
            baseMapper.deleteById(employee.getId());
            // 根据员工编号获取档案信息,并更新
            History history = historyMapper.selectByNumber(employee.getEmployeeNumber());
            history.setStatus(status);
            history.setOutTime(new Date());
            historyMapper.updateById(history);
        }
    }

    /**
     * 根据 ID 删除员工信息
     * 1.根据 ID 查询员工信息,并删除员工表记录
     * 2.更改档案表信息,将状态改为离职,更改离职时间
     * 注: (如不查询员工信息,会包 NPE 错误)
     *
     * @param id
     */
    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = baseMapper.selectById(id);
        baseMapper.deleteById(id);
        History history = historyMapper.selectByNumber(employee.getEmployeeNumber());
        history.setStatus("离职");
        history.setOutTime(new Date());
        historyMapper.updateById(history);
    }

    @Override
    public Employee selectByNumber(Integer employeeNumber) {
        return null;
    }

    @Override
    public Page<Employee> search(String input, int page) {
        return null;
    }

    @Override
    public List<Employee> select(Integer employeeNumber, String password) {
        return null;
    }

    /**
     * 将 Department/Position 信息补全到 Employee 中
     *
     * @param employee
     * @return
     */
    private Employee setObject(Employee employee) {
        // 从 Employee 中获取部们编号
        Integer departmentNumber = employee.getDepartmentNumber();
        // 根据部门编号查询获得部门信息
        Department department = departmentMapper.selectByNumber(departmentNumber);
        employee.setDepartment(department);

        // 从 Employee 中获取职称编号
        Integer positionNumber = employee.getPositionNumber();
        // 根据职称编号查询获得职称信息
        Position position = positionMapper.selectByNumber(positionNumber);
        employee.setPosition(position);

        return employee;
    }
}
