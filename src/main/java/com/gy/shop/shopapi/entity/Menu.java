package com.gy.shop.shopapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 菜单
 * @author gy
 * @date 2017-04-01
 */
@EqualsAndHashCode()
@Data
@Entity
@Table(name = "shop_menu")
public class Menu{
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    public static class IsLeaf {
        /**
         * 非节点
         */
        public static Integer No  = 0;

        /**
         * 节点
         */
        public static Integer Yes = 1;
    }

    /**
     * 菜单名称
     */
    private String name;
    /**
     * 上级菜单ID（0：无上级ID）
     */
    private String upId;
    /**
     * 菜单地址
     */
    private String path;
    /**
     * 是否叶子节点(0:不是 1：是)
     */
    private Integer isLeaf;
    /**
     * 状态(0:无效 1:有效)
     */
    private Integer state;
    /**
     * 创建人账号
     */
    private String updater;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatime;

    //////////////////// 冗余字段 ////////////////////
    @Transient
    private List<Menu> children;
    @Transient
    private boolean leaf;

    @Transient
    public List<Menu> getChildren() {
        return children;
    }
    @Transient
    public boolean getLeaf(){
        return isLeaf == IsLeaf.Yes;
    }
}
