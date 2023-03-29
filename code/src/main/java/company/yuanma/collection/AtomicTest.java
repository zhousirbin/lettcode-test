package company.yuanma.collection;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    public static AtomicInteger atomicInteger = new AtomicInteger(0); //属于类的，所有实例公用
   // public  AtomicInteger atomicInteger1 = new AtomicInteger(0); //属于对象的，每个对象都有一个



    public static void increase(){
       // atomicInteger.getAndIncrement();
        atomicInteger.getAndAdd(2) ; //指定增加某个步数
//        System.out.println(atomicInteger);
    }
    public static void main(String[] args){


        for (int i=0;i<10;i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    increase();
//                    System.out.println(("Thread"+String.valueOf(finalI)));
                }
            },String.valueOf(i)).start();
        }

        System.out.println(atomicInteger);


    }
}
