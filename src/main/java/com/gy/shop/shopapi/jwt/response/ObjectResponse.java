package com.gy.shop.shopapi.jwt.response;


/**
 * 返回数据
 *
 * @param <T>
 */
public class ObjectResponse<T> implements Response {
    /**
     * 返回编码
     */
    private String responseCode;
    /**
     * 返回消息
     */
    private String responseMsg;
    /**
     * 数据
     */
    private T datas;

    public ObjectResponse(String responseCode, String responseMsg, T datas) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
        this.datas = datas;
    }

    public ObjectResponse(T datas) {
        this.responseCode = CODE_SUCCESS;
        this.responseMsg = MSG_SUCCESS;
        this.datas = datas;
    }

    @Override
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * @param responseCode the responseCode to set
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String getResponseMsg() {
        return responseMsg;
    }

    /**
     * @param responseMsg the responseMsg to set
     */
    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    /**
     * @return the dateUtils
     */
    public T getDatas() {
        return datas;
    }

    /**
     * @param datas the dateUtils to set
     */
    public void setDatas(T datas) {
        this.datas = datas;
    }

    /**
     * (non-Javadoc)
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "ListResponse [responseCode=" + responseCode + ", responseMsg=" + responseMsg + ", dateUtils=" + datas + "]";
    }

}
