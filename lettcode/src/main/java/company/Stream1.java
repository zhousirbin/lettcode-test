package company;

import java.util.*;
import java.util.stream.Collectors;

public class Stream1 {

    public class Student{
        private int id;
        private String name;
        private int age;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }



    public static void main(String[] args) {


    List<Integer> nums = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 9), Arrays.asList(1, 8, 27))
            .stream().flatMap(x -> x.stream()).collect(Collectors.toList());
System.out.println(nums);



        Comparator<Integer> byName =
                ( o1,  o2)-> o1.intValue()-o2.intValue();

        List<Integer> nums1 = Arrays.asList(1,null,3,4,null,6);
        Set<Integer> a = nums1.stream().filter(num -> num != null && num != 1 )
                .map(c -> c*3).sorted((n1,n2) -> (n1.compareTo(n2))).collect(Collectors.toSet());//转换为set

        List<Integer> a1= nums1.stream().filter(num -> num != null && num != 1 )
                .map(c -> c*3).sorted((n1,n2) -> (n1.compareTo(n2))).collect(Collectors.toList());

        //Set<Integer> w = nums1.stream().filter(num -> num != null && num != 1 ).mapToInt(c -> c*3).sum();
        int d = nums1.stream().filter(num -> num != null && num != 1 ).mapToInt(c -> c*3).limit(2).sum();

        long w = nums1.stream().filter(num -> num != null && num != 1 ).count();

        OptionalInt w1 = nums1.stream().filter(num -> num != null && num != 1 ).mapToInt(c ->c).max();

        System.out.println(a);
        System.out.println(d);
        System.out.println("w = "+w);

        System.out.println("w1 = "+w1);

        System.out.println(a1);
//
//        Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
//
//        System.out.println(integerStream.toArray().toString());

        List<Integer> nums2 = Arrays.asList(1,null,4,3,null,6,5);

        List<Integer> a3 = nums2.stream().filter(num -> num != null && num != 1 ).map(c -> c*3)
                .sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());//定义自己的比较器Comparator.comparing(Integer::intValue)
        System.out.println("比较器"+a3);

        List<Integer> a4 = nums2.stream().filter(num -> num != null && num != 1 ).map(c -> c*3)
                .sorted().collect(Collectors.toList());//定义自己的比较器Comparator.comparing(Integer::intValue)
        System.out.println("a4"+a4);

        //Student b1 = new Student(1,"zh",4);

    }



}
