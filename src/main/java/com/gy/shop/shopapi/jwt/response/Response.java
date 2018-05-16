package com.gy.shop.shopapi.jwt.response;

/**
 * @author gy on 10:06 2018/1/5.
 * desc
 */
public interface Response {
    public static final String CODE_FAILED = "0";
    public static final String MSG_FAILED = "failed";
    public static final String CODE_SUCCESS = "1";
    public static final String MSG_SUCCESS = "success";

    /**
     * 返回结果编码
     *
     * @return
     */
    String getResponseCode();

    /**
     * 返回结果信息
     *
     * @return
     */
    String getResponseMsg();
}
