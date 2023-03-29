package company.yuanma.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ListShiTuTest {
    public static void main(String[] args){

        /*
        ArrayList
         */
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("b");

        List<String> list1 = Collections.unmodifiableList(list);
        for (String str :list1) {
            System.out.println(str);
        }
//        list1.add("s");//不支持再修改
        List sub = list.subList(0,1);

        list.add("w");
        sub.clear();
        sub.add("e");


       ArrayList arrayList = (ArrayList) list;//两个变量，同时引用一个对象，其中一个修改，另一个也修改。
       arrayList.add(new Date());//可以添加,,,[a, b, c, b, Fri Jan 25 14:29:19 CST 2019]


       System.out.println(arrayList);
        System.out.println(list);

       List<String> safeStrings = Collections.checkedList(arrayList,String.class);

        ArrayList arrayList1 = (ArrayList) safeStrings;
        arrayList1.add(new Date());//可以添加,

    }
}
