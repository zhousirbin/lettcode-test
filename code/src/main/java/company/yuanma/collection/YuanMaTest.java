package company.yuanma.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class YuanMaTest {
   public static void main(String[] args){
       String integer = new String("abfj");
       //System.out.println(integer.hashCode());

       String ab = new String("abc");
       ab.hashCode();

       LinkedList<String> linkedList = new LinkedList<>();
       linkedList.add("we");
       HashMap<String,Integer> hashMap = new HashMap<>(4);

       ConcurrentHashMap<String,Integer>  concurrentHashMap = new ConcurrentHashMap<>();


       //hashMap.put("a",8);
       for (int i=1;i<=8;i++){
           hashMap.put("a"+i,i);
       }
       System.out.println(hashMap);

       for(Map.Entry<String,Integer> entry:hashMap.entrySet()){
          System.out.println("key="+entry.getKey()+','+"value="+entry.getValue());
       }

       Iterator<Map.Entry<String,Integer>> entris= hashMap.entrySet().iterator();
       while (entris.hasNext()){
           Map.Entry<String,Integer> next = entris.next();
           System.out.println(next.getKey()+ "  "+next.getValue());


       }

       if (hashMap.containsKey("a2")){
           hashMap.remove("a2");
       }

       System.out.println(hashMap);



   }
}
