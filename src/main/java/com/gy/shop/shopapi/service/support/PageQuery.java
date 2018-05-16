package com.gy.shop.shopapi.service.support;

import lombok.Data;

import java.util.List;

/**
 * @Author gy
 * @Date: Create in 2018/4/3 14:33
 * @Description
 * @Modified By:
 */
@Data
public class PageQuery<T> {

    private Integer currentPage;
    private Integer pageSize;
    private Long count;
    private List<T> items;

}
