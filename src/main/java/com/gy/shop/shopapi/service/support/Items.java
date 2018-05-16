package com.gy.shop.shopapi.service.support;

import lombok.Data;

import java.util.List;

/**
 * @Author gy
 * @Date: Create in 2018/4/3 19:08
 * @Description
 * @Modified By:
 */
@Data
public class Items<T> {

    long count;
    List<T> items;

    public Items() {

    }

    public Items(long count, List<T> items) {
        this.count = count;
        this.items = items;
    }


}
