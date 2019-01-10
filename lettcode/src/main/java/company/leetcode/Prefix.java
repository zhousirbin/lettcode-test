package company.leetcode;

public class Prefix {

    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};
        String a = longestCommonPrefix(strs);
        System.out.println(a);
    }

    public static String longestCommonPrefix(String[] strs) {

       if (strs.length==0) return "";

       String prefix = strs[0];

       for (int i=1;i<strs.length;i++){
           while (strs[i].indexOf(prefix)!= 0){
               prefix = prefix.substring(0,strs.length-1);
               if (prefix =="") return "";
           }
       }
       return prefix;
    }

}
