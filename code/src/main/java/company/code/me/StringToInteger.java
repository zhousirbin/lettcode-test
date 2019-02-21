package company.code.me;

public class StringToInteger {

    public int myAtoi(String str) {
        if(str == null || str.length()==0){return 0;}
        int len = str.length();
        int i = 0,ans =0,sign=1;
        while(i<len && str.charAt(i) == ' '){
            i++;
        }

        if(i >= str.length()) return 0; //一定要加上范围，要不会越界
        if(str.charAt(i) == '+') i++;
        else if(str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        while(i<len && Character.isDigit(str.charAt(i))){
            if (ans>  Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            int num = str.charAt(i)-'0';
            ans = 10*ans+num;
            i++;
        }
        return sign*ans;

    }

    public static void main(String[] arg){

        //boolean a = isMatch("a*","aa");

        boolean b = isMatch1("aa","a*");

    }

    public static boolean isMatch(String pattern, String text) {

        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static boolean isMatch1(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
