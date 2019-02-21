package company.yuanma;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static void main(String[] args){

        DateTime today = (new DateTime()).withTimeAtStartOfDay();
        DateTime yesterday = today.plusDays(-1);
        System.out.println("today"+today);
        System.out.println("yes"+yesterday);

        Date date = new Date();
        System.out.println(date);



        SimpleDateFormat format = new SimpleDateFormat("dd");

        Integer billDay = Integer.parseInt(format.format(date));
        System.out.println(billDay);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);//1540537075128
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月的今天
        Date date1 = calendar.getTime();
        System.out.println("date1"+date1);//Wed Sep 26 15:15:08 CST 2018

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String a =format1.format(date1);//2018-09-26 15:04:22

        SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date2 = dateFormate.parse(a);//Wed Sep 26 15:15:08 CST 2018
            System.out.println(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
