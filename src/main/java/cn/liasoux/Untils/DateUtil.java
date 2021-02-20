package cn.liasoux.Untils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String stringToDate(Date str){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(str);
        return format1;
    }

}
