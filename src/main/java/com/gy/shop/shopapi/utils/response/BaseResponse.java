package com.gy.shop.shopapi.utils.response;

import lombok.Data;

/**
 * @Author gy
 * @Date: Create in 2018/3/30 20:37
 * @Description
 * @Modified By:
 */
@Data
public class BaseResponse {

    private int status;
    private String msg;

    public BaseResponse() {
    }

    public BaseResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
