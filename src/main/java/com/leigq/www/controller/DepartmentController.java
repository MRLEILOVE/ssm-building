package com.leigq.www.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.leigq.www.bean.Response;
import com.leigq.www.entity.Department;
import com.leigq.www.entity.Staff;
import com.leigq.www.service.DepartmentService;
import com.leigq.www.service.StaffService;
import com.leigq.www.util.DateUtil;
import com.leigq.www.util.POIUtil;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    public Response selectDepartments(PageInfo<Department> page) {
        return response.success(departmentService.selectDepartments(page));
    }

    /**
     * Excel导出所有部门
     * <br>创建人： asus
     * <br>创建时间： 2019-01-23 10:34
     * <br>
     */
    @GetMapping("/departments/action/export")
    public void exportDepartments(HttpServletResponse response) {
        List<Department> departments = departmentService.selectExportDepartments();
        POIUtil.exportExcel(departments, Department.class,
                "部门表" + DateUtil.dateTimeNoSymbol, "部门表", "sheet1", response);
    }

    /**
     * 根据部门名查询单个部门
     * <br>创建人： asus
     * <br>创建时间： 2019-01-15 17:10
     * <br>
     */
    @GetMapping("/departments/{name}")
    public Response getDepartmentByName(@PathVariable("name") String name) {
        return response.success(departmentService.getDepartmentByName(name));
    }

    /**
     * 添加一个部门
     * <br>创建人： asus
     * <br>创建时间： 2019-01-15 17:21
     * <br>
     */
    @PostMapping("/departments")
    public Response addDepartment(@Valid Department department){
        int r = departmentService.addDepartment(department);
        return r > 0 ? response.success("添加成功！", null) : response.failure("添加失败！", null);
    }

}
