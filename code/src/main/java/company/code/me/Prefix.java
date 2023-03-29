package company.code.me;

public class Prefix {

    public static void main(String[] args){
        String[] strs = {"flower","flow","floight"};
        String a = longestCommonPrefix(strs);
        System.out.println(a);
        int f=(9&0b1000)/0b1000;//9的二进制第四位是否为1
        System.out.println(f);
        int w = 4<<2;
        String result = Integer.toBinaryString(w);
        System.out.println(result);
        String a1 ="w";
        String a2 ="w";
        String a3 =a1 + a2;
        System.out.println(a1.hashCode()+"  "+a2.hashCode());
        System.out.println(a1==a2);
        System.out.println(a3.hashCode());
    }

    public static String longestCommonPrefix(String[] strs) {

       if (strs.length==0) return "";

       String prefix = strs[0];

       for (int i=1;i<strs.length;i++){
           while (strs[i].indexOf(prefix)!= 0){
               prefix = prefix.substring(0,prefix.length()-1);
               if (prefix =="") return "";
           }
       }
       return prefix;
    }

}
