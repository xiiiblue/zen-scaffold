package com.bluexiii.zenscaffold.util;

import com.bluexiii.zenscaffold.exception.DataFormatException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
    private StringUtils() {
    }

    public static String dateToStr(Date date) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (date == null) ? "" : sdf.format(date);
    }

    public static Date strToDate(String str) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            throw new DataFormatException("日期格式不正确");
        }
    }
}
