package com.leigq.www.controller;

import com.leigq.www.entity.Staff;
import com.leigq.www.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 员工
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
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    /**
     * 查询所有员工
     * <br>创建人： asus
     * <br>创建时间： 2019-01-15 17:40
     * <br>
     */
    @RequestMapping("/staffs")
    public List<Staff> selectStaffs() {
        return staffService.selectStaffs();
    }

}
