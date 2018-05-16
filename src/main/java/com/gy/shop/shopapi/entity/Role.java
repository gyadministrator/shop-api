package com.gy.shop.shopapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 角色
 * @author gy
 * @date 2017-04-01
 */
@EqualsAndHashCode()
@Data
@Entity
@Table(name = "shop_role")
public class Role{
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;
    /**
     * 角色
     */
    public static interface Type {
        /**
         * 管理员
         */
        public static final String ADMIN        = "ADMIN";
        /**
         * 采购管理员
         */
        public static final String PURCHASER    = "PURCHASER";
        /**
         * 销售管理员
         */
        public static final String SELLER       = "SELLER";
        /**
         * 库存管理员
         */
        public static final String STOCKR       = "STOCKR";
    }

    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色编码
     */
    private String code;
    /**
     * 角色描述
     */
    private String descs;
    /**
     * 角色菜单
     */
    private String menuIds;
    /**
     * 角色名称
     */
    private String menuNames;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 创建人账号
     */
    private String updater;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatime;
}
