package com.leigq.www.service;

import com.leigq.www.entity.Staff;
import com.leigq.www.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  员工
 * <p>
 * 创建人：asus <br>
 * 创建时间：2019-01-15 15:27 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Service
@Transactional
public class StaffService {

    @Autowired
    private StaffMapper staffMapper;

    public List<Staff> selectStaffs() {
        return staffMapper.selectStaffs();
    }
}
