package com.gy.shop.shopapi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/5/4 14:33
 * @email 1984629668@qq.com
 * @description 日期转化
 */
public class DateUtils {
    public static Date getDate(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
