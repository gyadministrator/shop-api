package com.gy.shop.shopapi.utils.response;

import lombok.Data;

import java.util.List;

/**
 * @Author gy
 * @Date: Create in 2018/4/3 19:03
 * @Description
 * @Modified By:
 */
@Data
public class ListResponse extends BaseResponse {

    private long count;
    private List items;

}
