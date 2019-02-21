package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args){


        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);
        for (String player : players) {
            System.out.print(player + "; ");
        }

        Comparator<String> sortByNameLenght = (s1, s2) -> (s1.length() - s2.length());
        Arrays.sort(atp, sortByNameLenght);

        System.out.println( "************");

// 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }

// 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));
        StringBuffer w = new StringBuffer();
        players.forEach(w::append);
        System.out.println("12"+w);

// 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);

        Collections.sort(players,(String s1,String s2)->{return s1.compareTo(s2);});//大括号里存放的是方法体

        Collections.sort(players,(s1, s2)->(s1.compareTo(s2)));
        Collections.sort(players,(s1, s2)->(s1.length()-s2.length()));



//        players.stream().sorted((a1,a2)->{a1.length()-a2.length()}).collect()
    }
}
