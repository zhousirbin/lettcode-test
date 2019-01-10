package company.random;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomTest {

        public static void testDate()
        {
            Date date = new Date();
            System.out.println(date);

            long timeMill = date.getTime();//获取当前时间---毫秒级
            System.out.println(timeMill);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String b1 = simpleDateFormat.format(date);
            System.out.println("b1,  "+b1);


            String a1 ="1531820604449";
            String a = simpleDateFormat.format(timeMill); // 2018-07-17 17:43:24
            String a2 = simpleDateFormat.format(Long.parseLong(a1));  // 如果是字符串，需要将字符串转换为Long
            System.out.println("a2,  "+a2);
            System.out.println(a);

            Date date1 =null;
            Long dataMil = null;
            try {
                 date1 = simpleDateFormat.parse(a); //Tue Jul 17 17:43:24 CST 2018

                dataMil= simpleDateFormat.parse(a).getTime();  //1531820604000
            } catch (ParseException e) {
                e.printStackTrace();
            }

            System.out.println("date1,"+date1);
            System.out.println("dataMil,"+dataMil);

            Random rand = new Random(timeMill);
            for(int i = 0; i < 20; i++)
            {
                System.out.println(rand.nextInt(50));
            }
        }


    public static String getRandomNumber(int digCount) {

        Date date = new Date();

        long timeMill = date.getTime();
        StringBuilder sb = new StringBuilder(digCount);
        Random rnd = new Random(timeMill);
        for(int i=0; i < digCount; i++)
            sb.append((char)('0' + rnd.nextInt(10)));
        System.out.println(sb);
        return sb.toString();
    }
    public static void main(String[] args)
        {
            testDate();
           getRandomNumber(4);
        }

}
