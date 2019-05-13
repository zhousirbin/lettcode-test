package company.code.me;

public class DividTest29 {

        public static void main(String[] args){
           int a =  divide(-2147483647
                   ,2);
           System.out.println(a);

        }
        public static int divide(int dividend, int divisor) {

            if (divisor == 1){
                return dividend;
            }
            if (divisor == -1){

                if(dividend == Integer.MIN_VALUE)return Integer.MAX_VALUE;
                else {
                    return -dividend;
                }

            }
            long divAbs  = Math.abs((long)dividend);
            System.out.println(divAbs);
            long diviAbs = Math.abs(divisor);
            int count = 0;
            int a = 0 ;
            while (divAbs>=diviAbs){

                divAbs = divAbs- diviAbs;
                count++;
           }
           a = count;
            if (dividend < 0 && divisor >0 || dividend >0 && divisor <0){
                a = -count;
            }
            return  a;

        }

}
