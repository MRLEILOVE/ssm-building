package com.leigq.www.controller;

import com.leigq.www.bean.Response;
import com.leigq.www.entity.Department;
import com.leigq.www.entity.Staff;
import com.leigq.www.service.DepartmentService;
import com.leigq.www.service.StaffService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 部门
 * <p>
 * 创建人：asus <br>
 * 创建时间：2019-01-15 15:31 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@RestController
public class DepartmentController {

    private final DepartmentService departmentService;
    private final Response response;

    @Autowired
    public DepartmentController(DepartmentService departmentService, Response response) {
        this.departmentService = departmentService;
        this.response = response;
    }

    /**
     * 查询所有部门
     * <br>创建人： asus
     * <br>创建时间： 2019-01-15 17:10
     * <br>
     */
    @GetMapping("/departments")
    public Response selectDepartments() {
        return response.success(departmentService.selectDepartments());
    }

    /**
     * 根据部门名查询单个部门
     * <br>创建人： asus
     * <br>创建时间： 2019-01-15 17:10
     * <br>
     */
    @GetMapping("/department/{name}")
    public Response getDepartmentByName(@PathVariable("name") String name) {
        return response.success(departmentService.getDepartmentByName(name));
    }

    /**
     * 添加一个部门
     * <br>创建人： asus
     * <br>创建时间： 2019-01-15 17:21
     * <br>
     */
    @PostMapping("/department")
    public Response addDepartment(@Valid Department department){
        int r = departmentService.addDepartment(department);
        return r > 0 ? response.success("添加成功！", null) : response.failure("添加失败！", null);
    }

}
