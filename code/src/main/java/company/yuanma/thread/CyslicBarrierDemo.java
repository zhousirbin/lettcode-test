package company.yuanma.thread;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyslicBarrierDemo {

    public static void main(String[] args){
        int totalThread = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
        while (true){
//        for(int i=0; i< totalThread;i++){
            String threadName = "Thread";
            new Thread(()->{
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, " is waiting"));
                try {
                    cyclicBarrier.await(); //实际上是阻塞子进程，到这进程停止，前面的都执行完了
                   // System.out.println(String.format("%s\t%s %s", new Date(), threadName, " is running"));
                    //cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }


                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "ended"));

            }).start();

            new Thread(()->{
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, " is waiting"));

                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "ended"));

            }).start();
        }
    }
}
