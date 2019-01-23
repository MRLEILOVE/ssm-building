package com.leigq.www.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.leigq.www.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *  部门实体
 * <p>
 * 创建人：asus <br>
 * 创建时间：2019-01-15 10:29 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Department extends BaseEntity {

    @Excel(name = "部门名称")
    @NotBlank(message = "{department_name_not_empty}")
    private String name;

}
