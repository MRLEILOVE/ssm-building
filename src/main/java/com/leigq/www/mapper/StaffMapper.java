package com.leigq.www.mapper;

import com.leigq.www.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  员工
 * <p>
 * 创建人：asus <br>
 * 创建时间：2019-01-15 15:33 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
public interface StaffMapper {
    List<Staff> selectStaffs();
}
