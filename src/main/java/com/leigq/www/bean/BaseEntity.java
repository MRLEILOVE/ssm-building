package com.leigq.www.bean;

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

    private Long id;

    private Date createTime;

    private Date updateTime;

}
