package company.yuanma.collection;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args){

        int h = 4;
        h = h >>> 1; //右移，高位补0
        System.out.println(h);
        String a ="a";
        System.out.println(a.hashCode());
        binaryToDecimal(97);//00000000000000000000000001100001
        System.out.println();
        Integer.toBinaryString(9);
        binaryToDecimal1(97);

        HashMap hashMap = new HashMap(0);
        hashMap.put("1",2);
        System.out.println(hashMap.get("1"));

    }

    HashMap hashMap = new HashMap();

    public static  int hash(Object key) {
        int h;

        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void binaryToDecimal(int n){
              for(int i = 31;i >= 0; i--)
                      System.out.print(n >>> i & 1);

    }

    public static void binaryToDecimal1(int n){
        String str = "";
        while(n!=0){
            str = n%2+str;
            n = n/2;
        }
        System.out.println(str);
    }



}
