package company.yuanma;

import java.util.*;

public class StringTest {

    public static void main(String[] args){

        /*
         *hashCode--哈希值
         */
        String integer = new String("a1");//a是97，1是49，31^1*97+46=3056
        //System.out.println(integer.hashCode());
        System.out.println(integer.hashCode());
        System.out.println("1".hashCode());//46
        System.out.println(integer.startsWith("gun"));


        /*
         *indexOf--查找索引
         */
        System.out.println(integer.indexOf("1"));//查询指定字符串的初始位置
        System.out.println(integer.indexOf(49));//a character (Unicode code point),1的Unicode值

        String w = "qeijbmijsnbinij";
        System.out.println(w.indexOf("ij"));
        System.out.println(w.indexOf("ij",0));
        System.out.println(w.indexOf("ij",3));

        /*
         *split--替换
         */
        String w1 = "qeijbmijsnbinij";
        System.out.println(w1.replaceFirst("ij","1i"));//替换第一个出现的字符串

        System.out.println(w1.replace("ij","wq"));//替换所有出现的字符串

        /*
         *split--分割
         */
        String[] ab = w1.split("ij");//全部分隔，与limit为0同样的效果
        for (String string:ab) {
            System.out.println(string);

        }
        String[] ab1 = w1.split("ij",0);//可以限制几个，分隔为几个字符串，3就会分隔为3个字符串，
        for (String string:ab1) {
            System.out.println(string);

        }

        /*
         *join--连接
         */
        String message = String.join(" ","this","is","java");//支持多个字符串序列连接
        System.out.println("join :"+message);

        List<String> list = new ArrayList<>();
        list.add("this");
        list.add("is");
        list.add("me");

        String message1 = String.join(",",list);//支持list,set,
        System.out.println(message1);

        List<String> strings = new LinkedList<>();
        strings.add("Java");strings.add("is");
        strings.add("cool");
        String message2 = String.join(" ", strings);

        Set<String> strings1 = new LinkedHashSet<>();//支持set
        strings.add("Java"); strings.add("is");
        strings.add("very"); strings.add("cool");
        String message3 = String.join("-", strings1);

        String wq = " qeijbmi jsnbinij ";
        System.out.println(wq.trim());//只能去掉头部和尾部的空格

        char[] chars = {'a','b','c'};

        System.out.println(String.valueOf(chars));//转化为字符串,支持字符数组、int、long、float、double、


        String str[] = {"a","b","c","d","a","b","c","d","a","b","c","d",
                "a","b","c","d","a","b","c","d","a","b","c","d"};
        Formatter formatter = new Formatter(System.out);
        int i= 1;
        for(String son: str){
            if(i%4==0){
                formatter.format("%-5s %-5s %-5s %-5s\n", str[i-4],str[i-3],str[i-2],str[i-1]);
            }
            i++;
        }
        formatter.close();





    }
}
