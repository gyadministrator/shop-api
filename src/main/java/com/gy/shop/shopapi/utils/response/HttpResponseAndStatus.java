package com.gy.shop.shopapi.utils.response;
import com.gy.shop.shopapi.service.support.Items;
import com.gy.shop.shopapi.service.support.PageQuery;
import org.jetbrains.annotations.NotNull;

import static com.gy.shop.shopapi.utils.response.HttpStatusAndMsg.exs;

/**
 * @Author gy
 * @Date: Create in 2018/3/30 20:37
 * @Description 统一实例返回格式
 * @Modified By:
 */
public class HttpResponseAndStatus {


    public final static BaseResponse baseResponse(int status) {
        return baseResponse(status, null);
    }


    public final static BaseResponse baseResponse(int status, String msg) {

        if (msg != null) {
            return new BaseResponse(status, exs.get(status) + ":" + msg);
        } else {
            return new BaseResponse(status, exs.get(status));
        }
    }


    public final static SimpleResponse simpleResponse(int status) {
        return simpleResponse(status, null, null);
    }

    public final static SimpleResponse simpleResponse(int status, String msg) {
        return simpleResponse(status, msg, null);
    }

    public final static SimpleResponse simpleResponse(int status, Object data) {
        return simpleResponse(status, null, data);
    }


    public final static SimpleResponse simpleResponse(int status, String msg, Object data) {

        SimpleResponse response = new SimpleResponse();
        response.setStatus(status);
        if (msg != null) {
            response.setMsg(msg);
        } else {
            response.setMsg(exs.get(status));
        }
        response.setData(data);
        return response;
    }

    public final static PageAndSortResponse pageAndSortResponse(int status, PageQuery query) {
        return pageAndSortResponse(status, null, query);
    }

    public final static PageAndSortResponse pageAndSortResponse(int status, String msg, @NotNull PageQuery query) {
        PageAndSortResponse response = new PageAndSortResponse();
        response.setCurrentPage(query.getCurrentPage());
        response.setPageSize(query.getPageSize());
        response.setCount(query.getCount());
        response.setStatus(status);
        response.setItems(query.getItems());
        if (msg != null) {
            response.setMsg(exs.get(status) + ":" + msg);
        } else {
            response.setMsg(exs.get(status));
        }

        return response;
    }

    public final static ListResponse listResponse(int status, Items items) {
        return listResponse(status, null, items);
    }


    public final static ListResponse listResponse(int status, String msg, @NotNull Items items) {
        ListResponse response = new ListResponse();
        response.setCount(items.getCount());
        response.setItems(items.getItems());

        if (msg != null) {
            response.setMsg(exs.get(status) + ":" + msg);
        } else {
            response.setMsg(exs.get(status));
        }
        response.setStatus(status);
        return response;

    }


}
