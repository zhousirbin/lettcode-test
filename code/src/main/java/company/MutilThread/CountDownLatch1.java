package company.MutilThread;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CountDownLatch1 {

    public static void main(String[] args){
        int totalThread = 1;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);

      //  CountDownLatch countDownLatch1 = new CountDownLatch(3);
        for (int i=0;i<3;i++){
//            Thread thread = new Thread(new Runnable() {  //其中一种方式
//                @Override
//                public void run() {
//                    System.out.println("xunhuan");
//
//                }
//            });
//            thread.start();
            final String threadName = "Thread " + i;
            new Thread(new Runnable() {      //另一种方式
                @Override
                public void run() {
                    System.out.println(String.format("%s\t%s %s", new Date(), threadName, "started"));
                    try {
                        countDownLatch.await();
                        // countDownLatch1.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(String.format("%s\t%s %s", new Date(), threadName, "ended"));
                }
            }).start();
        }

        countDownLatch.countDown();
        long start = System.currentTimeMillis();

        System.out.println("开始");
//        try {
//            countDownLatch1.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        long stop = System.currentTimeMillis();
        System.out.println("结束");
        System.out.println(String.format("Total time : %sms", (stop - start)));

    }

}
