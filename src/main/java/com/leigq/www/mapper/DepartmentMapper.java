package com.leigq.www.mapper;

import com.leigq.www.entity.Department;
import com.leigq.www.entity.Staff;
import org.apache.ibatis.annotations.Param;

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
public interface DepartmentMapper {

    /**
     * 查询所有部门
     * <br>创建人： asus
     * <br>创建时间： 2019-01-15 17:06
     * <br>
     */
    List<Department> selectDepartments();

    /**
     * 根据部门名查询单个部门
     * <br>创建人： asus
     * <br>创建时间： 2019-01-15 17:10
     * <br>
     */
    List<Department> getDepartmentByName(@Param("name") String name);

    /**
     * 添加一个部门
     * <br>创建人： asus
     * <br>创建时间： 2019-01-15 17:21
     * <br>
     */
    int addDepartment(Department department);
}
