package com.gy.shop.shopapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 系统用户
 * @author gy
 * @date 2017-04-01
 */
@EqualsAndHashCode()
@Data
@Entity
@Table(name = "shop_user")
public class User{
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;
    /**
     * 锁定
     */
    public static interface IsLocked {
        /**
         * 未锁定
         */
        public static final int NO  = 0;
        /**
         * 已锁定
         */
        public static final int YES = 1;
    }

    /**
     * 用户账号
     */
    private String  account;
    /**
     * 用户密码
     */
    private String  password;
    /**
     * 用户角色Id
     */
    private String   roleId;
    /**
     * 角色名称
     */
    private String  roleName;
    /**
     * 员工ID
     */
    private Long    employeeId;
    /**
     * 修改人账号
     */
    private String  updater;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date    updatime;
    /**
     * 账号状态
     */
    private Integer state;
    /**
     * 是否锁定 <br/>
     * 0 未锁定 <br/>
     * 1 锁定 <br/>
     */
    private Integer isLocked;
    /**
     * 锁定时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date    lockTime;

    //////////////////// 冗余字段 ////////////////////

    @Transient
    private String  employeeName;
    @Transient
    private String  employeeCode;


    @Transient
    public String getEmployeeName() {
        return employeeName;
    }
    @Transient
    public String getEmployeeCode() {
        return employeeCode;
    }
}
