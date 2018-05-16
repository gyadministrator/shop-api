package com.gy.shop.shopapi.utils.response;

import lombok.Data;

import java.util.List;

/**
 * @Author gy
 * @Date: Create in 2018/3/30 20:37
 * @Description
 * @Modified By:
 */
@Data
public class PageAndSortResponse extends BaseResponse {

    private Integer currentPage;
    private Integer pageSize;
    private long count;
    List items;

}
