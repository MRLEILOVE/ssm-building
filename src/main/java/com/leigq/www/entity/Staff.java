package com.leigq.www.entity;

import com.leigq.www.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  员工实体
 * <p>
 * 创建人：asus <br>
 * 创建时间：2019-01-15 10:28 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Staff extends BaseEntity {
    private String number;
    private String name;

    /*所属部门*/
    private Department department;
}
