package company.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
        private static String firstDay;
        private static String lastDay;
        public static void main(String[] args) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date date = new Date();//Wed Feb 13 16:17:49 CST 2019
            System.out.println(date);
            try {
                Date date1 = getEndTime(date);//Wed Feb 13 00:00:00 CST 2019
                System.out.println(date1);

            } catch (Exception e) {
                e.printStackTrace();
            }


            //获取前月的第一天
            Calendar cal_1=Calendar.getInstance();//获取当前日期
            cal_1.add(Calendar.MONTH, -1);
            cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
            firstDay = format.format(cal_1.getTime());
            System.out.println("-----1------firstDay:"+firstDay);
            //获取前月的最后一天
            Calendar cale = Calendar.getInstance();
            cale.set(Calendar.DAY_OF_MONTH,0);//设置为1号,当前日期既为本月第一天
            lastDay = format.format(cale.getTime());
            System.out.println("-----2------lastDay:"+lastDay);


            //获取当前月第一天：
//            Calendar c = Calendar.getInstance();
//            c.add(Calendar.MONTH, 0);
//            c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
//            String first = format.format(c.getTime());
//            System.out.println("===============first:"+first);
//
//            //获取当前月最后一天
//            Calendar ca = Calendar.getInstance();
//            ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
//            String last = format.format(ca.getTime());
//            System.out.println("===============last:"+last);

         //获取当前月第一天0点-----2019-02-01 00:00:00
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, 0);
            c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
            //将小时至0
            c.set(Calendar.HOUR_OF_DAY, 0);
            //将分钟至0
            c.set(Calendar.MINUTE, 0);
            //将秒至0
            c.set(Calendar.SECOND,0);
            //将毫秒至0
            c.set(Calendar.MILLISECOND, 0);
            // 获取本月第一天的时间戳
            System.out.println(format.format(c.getTimeInMillis()));

            //获取当前月最后一天---2019-02-28 00:00:00
            Calendar ca = Calendar.getInstance();
            ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
            //将小时至0
            ca.set(Calendar.HOUR_OF_DAY, 0);
            //将分钟至0
            ca.set(Calendar.MINUTE, 59);
            //将秒至0
            ca.set(Calendar.SECOND,59);
            //将毫秒至0
            ca.set(Calendar.MILLISECOND, 0);
            // 获取本月最后一天的时间戳
            System.out.println(format.format(ca.getTimeInMillis()));



        }
        /**
         * 字符串的日期格式的计算
         */
        public static int daysBetween(String smdate,String bdate) throws ParseException {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(smdate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(bdate));
            long time2 = cal.getTimeInMillis();
            long between_days=(time2-time1)/(1000*3600*24);
            return Integer.parseInt(String.valueOf(between_days));
        }

    private static Date getEndTime(Date date) throws Exception {
        //yyyy-MM-dd 00:00:00
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String s = format.format(date) + " 00:00:00";
        //yyyy-MM-dd HH:mm:ss
        SimpleDateFormat form= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = form.parse(s);
        return date;
    }

}
