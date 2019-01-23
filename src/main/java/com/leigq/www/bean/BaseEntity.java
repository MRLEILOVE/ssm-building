package com.leigq.www.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础Entity
 * <br>创建人： asus
 * <br>创建时间： 2019-01-15 17:40
 * <br>
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1308319624577045638L;

    @Excel(name = "ID", orderNum = "1")
    private Long id;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss", width = 20)
    private Date createTime;

    @Excel(name = "修改时间", format = "yyyy-MM-dd HH:mm:ss", width = 20)
    private Date updateTime;

}
