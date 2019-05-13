package company.code.me;

import java.util.HashSet;
import java.util.Set;

public class LongestTest {

    //最长不重复子串
    public static void main(String[] args) {
        int a = lengthOfLongestSubstring("ahhbcunndrf");
        int b = lengthOfLongestSubstring1("asdffegdnc");
        System.out.println(a);
    }

    public static int lengthOfLongestSubstring(String s) {

        int length = s.length();
        if (s.equals("")) {
            return 0;
        }
        int le = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length - 1; j++) {
                if (s.charAt(j) != s.charAt(j + 1)) {
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
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));//当I等于4时候进入
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        int i = 0, j = 0;
        int l1 = 0;
        Set<Character> set = new HashSet<>();
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                l1 = Math.max(l1, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
      return l1;

     }

}
