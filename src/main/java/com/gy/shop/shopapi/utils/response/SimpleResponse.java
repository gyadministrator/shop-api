package com.gy.shop.shopapi.utils.response;

import lombok.Data;

/**
 * @Author gy
 * @Date: Create in 2018/3/30 20:37
 * @Description
 * @Modified By:
 */

@Data
public class SimpleResponse extends BaseResponse {

    private Object data;

    public SimpleResponse() {
    }

    public SimpleResponse(int status, String msg, Object data) {
        super(status, msg);
        this.data = data;
    }


}
