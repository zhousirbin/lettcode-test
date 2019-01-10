package company.yuanma;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args){

        Set<String> stringSet = new HashSet<String>();

        stringSet.add("1");
        stringSet.add("2");
        System.out.println(stringSet.add("1"));
        System.out.println(stringSet);

    }

}
