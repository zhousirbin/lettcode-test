package company.code.me;

public class Multiply43 {

    /*

Given two non-negative integers num1 and num2 represented as strings,
return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

     */
    public static void main(String[] args){
        int a = 0;
        System.out.println(a);
        multiply1("123","45");

    }


    public String multiply(String num1, String num2) {

        Long num3 = Long.parseLong(num1);
        Long num4 = Long.parseLong(num2);
        Long sum = 0L;
        for (long i=0;i<num3;i++){
            sum = sum + num4;

        }
        return sum.toString();
    }

    public static String multiply1(String num1, String num2) {


        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] = sum / 10+pos[p1];//加个位
                pos[p2] = (sum) % 10;//十位
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) {
            if(!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static String multiply2(String num1, String num2) {


        int m = num1.length(), n = num2.length();

        int[] post = new int[m+n];

        for (int i=m-1;i>=0;i--){

            for (int j=n-1;j>=0;j--){

                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int pos1 = i+j; int pos2 = i+j+1;
                int sum = mul + post[pos2];

                post[pos1] += sum/10;
                post[pos2] = sum%10;


            }
        }

        return "";
    }

}
