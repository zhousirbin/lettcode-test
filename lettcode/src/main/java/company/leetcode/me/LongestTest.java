package company.leetcode.me;

import java.util.HashSet;
import java.util.Set;

public class LongestTest {
    public static void main(String[] args){
     int a = lengthOfLongestSubstring("ahhbcunndrf");
     int b = lengthOfLongestSubstring1("asdffegdnc");
     System.out.println(a);
    }

    public static int lengthOfLongestSubstring(String s) {

        int length = s.length();
        if(s.equals("")){
            return 0;
        }
        int le = 0;
        for (int i=0;i<length;i++){
            for(int j=i;j<length-1;j++){
                if (s.charAt(j)!=s.charAt(j+1)){
                    le++;
                }

            }
        }

        return le;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));//当I等于4时候进入
            }
        }
        return ans;
    }
}
