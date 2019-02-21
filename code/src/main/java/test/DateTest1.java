package test;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTest1 {

    public static void main(String[] args) throws Exception {

        //这个方法可以，输出的是毫秒
        long epoch = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-06-08 16:33:00").getTime();

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-06-08 16:33:00"));

        Date ab1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-06-08 16:33:00");

//        java.sql.Date date = new java.sql.Date(1543753794);
//        System.out.println(date.getHours());
        String abc =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(ab1);

        System.out.println(abc);


        // 1528387200 表示时间为2018-06-08 00:00:00
//        long epoch1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-06-08").getTime()/1000;
        // 1255077180000
        long epoch2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("09/22/2008 16:33:00").getTime()/1000;
        System.out.println(epoch);

//        System.out.println("epoch1"+" "+epoch1);

        String a = getNowTimeStamp();
        System.out.println(a);

        String data = TimeStamp2Date(a,null);

        System.out.println("data"+data);

        Date ab = formatDate("1528446780000",null);
        System.out.println("ab"+ab);

    }

    public static String getNowTimeStamp() {
        long time = System.currentTimeMillis();
        String nowTimeStamp = String.valueOf(time / 1000);
        return nowTimeStamp;
    }

    /**
     * 取得当前时间戳（精确到秒）
     *
     * @return nowTimeStamp
     */
    public static String Date2TimeStamp(String dateStr, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(dateStr).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 日期格式字符串转换成时间戳
     *
     * @param timestampString  字符串日期
     * @param formats   如：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */

    public static String TimeStamp2Date(String timestampString, String formats) {
        if (StringUtils.isEmpty(formats))
            formats = "yyyy-MM-dd HH:mm:ss";
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return date;
    }

    public static Date formatDate(String date, String pattern) throws ParseException {
        if (StringUtils.isEmpty(pattern))
            pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat dateFormate = new SimpleDateFormat(pattern);
        return dateFormate.parse(date);
    }

    public static String formatDateWithSecond(Long dateLong, String pattern) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dateLong * 1000);
        Date date = cal.getTime();
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
}
