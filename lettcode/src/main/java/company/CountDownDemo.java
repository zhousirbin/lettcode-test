package company;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CountDownDemo {
    public static void main(String[] args) throws InterruptedException {   //主线程
        int totalThread = 3;
        long start = System.currentTimeMillis();
        CountDownLatch countDown = new CountDownLatch(totalThread);
        for(int i = 0; i < totalThread; i++) {    //子线程
            final String threadName = "Thread " + i;
            new Thread(() -> {
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "started"));
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("循环");
                countDown.countDown(); //每一个线程执行完减一，当减少为0时，主线程激活
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "ended"));
            }).start();
        }
        try {
            countDown.await();   //主线程等待三个线程执行完，实际上是阻塞主线程执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long stop = System.currentTimeMillis();
        System.out.println(String.format("Total time : %sms", (stop - start)));
    }
}
