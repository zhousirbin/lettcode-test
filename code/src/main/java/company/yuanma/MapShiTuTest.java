package company.yuanma;

import java.util.*;

public class MapShiTuTest {
    public static void main(String[] args){

        /*
        ArrayList
         */


        Set<String> strings = new HashSet<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");

        Set<String> strings1 = new HashSet<>();
        strings1.add("a");
        strings1.add("b");

        strings.retainAll(strings1);
        System.out.println(strings);


        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("b");

        Set<String> strings2 = new HashSet<>(list);//list自动转化为set

        String[] ws = {"a","b","c"};
        Set<String> strings3 = new HashSet<>(Arrays.asList(ws));//list自动转化为set
        String[] strings4 = strings3.toArray(new String[0]);//新建一个数组
        String[] strings5 = strings3.toArray(new String[3]);//不新建数组

        System.out.println(strings4==strings5);
        System.out.println(ws==strings5);
    }
}
