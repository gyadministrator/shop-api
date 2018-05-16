package com.gy.shop.shopapi.jwt.response;

/**
 * 返回消息封装
 *
 * @param <T>
 */
public class FailedResponse<T> implements Response {
    /**
     * 返回编码
     */
    private String responseCode;

    /**
     *   返回信息
     */
    private String responseMsg;

    public FailedResponse() {
        this.responseCode = Response.CODE_FAILED;
        this.responseMsg = Response.MSG_FAILED;
    }

    public FailedResponse(String responseCode, String responseMsg) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public FailedResponse(String responseMsg) {
        this.responseCode = Response.CODE_FAILED;
        this.responseMsg = responseMsg;
    }

    @Override
    public String getResponseCode() {
        return responseCode;
    }

    @Override
    public String getResponseMsg() {
        return responseMsg;
    }

}
