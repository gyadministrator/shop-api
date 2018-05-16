package com.gy.shop.shopapi.utils.response;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author gy
 * @Date: Create in 2018/3/30 20:37
 * @Description 状态码和对应消息
 * @Modified By:
 */
public class HttpStatusAndMsg {

    public final static Map<Integer, String> exs = new HashMap<>();

    static {

        exs.put(200, "Request Success");
        exs.put(400, "Bad Request"); // 参数问题
        exs.put(401, "NotAuthorization"); // 未认证
        exs.put(404, "Not Found");// 找不到
        exs.put(405, "Method Not Allowed"); // 请求方法不正确
        exs.put(415, "Unsupported Media Type"); // 不支持Media Type
        exs.put(500, "Internal Server Error");//服务器内部错误
        exs.put(1000, "UnKnow Error");//未知错误

        exs.put(1001, "UnKnowException"); // 未知异常
        exs.put(1002, "RuntimeException"); // 运行时异常
        exs.put(1003, "ClassCastException"); // 类型转换异常
        exs.put(1004, "NullPointerException"); // 空指针异常
        exs.put(1005, "IOException");// IO 异常
        exs.put(1006, "NoSuchMethodException");//找不到方法
        exs.put(1007, "IndexOutOfBoundsException");// 数组越界
    }


}
