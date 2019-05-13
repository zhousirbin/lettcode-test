package company.yuanma;

import org.joda.time.DateTime;

public class Test1 {
    public static void main(String[] args) {

        boolean s = isPalindrome(121);
        System.out.println(s);

        DateTime today = (new DateTime()).withTimeAtStartOfDay();
        DateTime yesterday = today.plusDays(-1);
        System.out.println(yesterday);
        System.out.println(today);



    }
        public static boolean isPalindrome ( int x){

            int b=x;
            boolean a = false;
            if (x > 0) {
                int result = 0;
                while (x != 0) {
                    int yu = x % 10;
                    int newResult = 10 * result + yu;
                    x = x / 10;
                    result = newResult;
                }
                System.out.println("b="+b);
                System.out.println(result);
                 if(b==result){
                     a=true;

                    }

            }
            return a;
        }

}
