package cn.liasoux.Untils;

import java.text.SimpleDateFormat;

public class DateUtil {

    public static String stringToDate(String str){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(str);
        return format1;
    }

}
