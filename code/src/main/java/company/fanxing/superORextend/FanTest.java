package company.fanxing.superORextend;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FanTest {


    //get--只能接受子类型，而且只能调用超类型的方法。
    public static double sum(Collection<? extends Number> numbers){

        double sum =0;
        for (Number number:numbers) {
            sum+=number.doubleValue();
        }

        return sum;
    }

    //put--只能接受超类型，添加的时候，可以添加各种超类型下的子类型，
    public static void add(Collection<? super Integer> numbers, int n){

        for (int i=0;i<n;i++){
            numbers.add(i);

        }
    }

    public static void main(String[] args){

        List<Integer> list  = Arrays.asList(1,2,3,4);
        List<Long>    list1 = Arrays.asList(12L,13L,14L);
        List<Double>   list2 = Arrays.asList(1.2,1.3,1.4);
        double w = sum(list);
        double q = sum(list1);
        double x = sum(list2);
        System.out.println(w);
        System.out.println(q);
        System.out.println(x);

        List<Integer> list4  = new ArrayList<>();
        add(list4,4);
        System.out.println(list4);
        List<Number> list5  = new ArrayList<>();
        add(list5, 5);
        System.out.println(list5);

//        List<Double> list6  = new ArrayList<>(); //这个不可以
//        add(list6,8);


//        new InvocationHandler(){
//
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("开始事务2");
//                //执行目标对象方法
//                Object returnValue = method.invoke(target, args);
//                System.out.println("提交事务2");
//                return returnValue;
//            }
//
//        }


    }



}
