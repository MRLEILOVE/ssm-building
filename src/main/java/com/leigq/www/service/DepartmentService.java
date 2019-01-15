package com.leigq.www.service;

import com.leigq.www.entity.Department;
import com.leigq.www.entity.Staff;
import com.leigq.www.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  部门
 * <p>
 * 创建人：asus <br>
 * 创建时间：2019-01-15 17:06 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Service
@Transactional
public class DepartmentService {

    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentService(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    /**
     * 查询所有部门
     * <br>创建人： asus
     * <br>创建时间： 2019-01-15 17:06
     * <br>
     */
    public List<Staff> selectDepartments() {
        return departmentMapper.selectDepartments();
    }

    /**
     * 根据部门名查询单个部门
     * <br>创建人： asus
     * <br>创建时间： 2019-01-15 17:10
     * <br>
     */
    public List<Department> getDepartmentByName(String name) {
        return departmentMapper.getDepartmentByName(name);
    }

    /**
     * 添加一个部门
     * <br>创建人： asus
     * <br>创建时间： 2019-01-15 17:21
     * <br>
     */
    public int addDepartment(Department department) {
        return departmentMapper.addDepartment(department);
    }
}
