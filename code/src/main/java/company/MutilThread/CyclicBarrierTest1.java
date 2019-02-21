package company.MutilThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest1 {
        public static void main(String[] args) {
            int N = 4;
            CyclicBarrier barrier  = new CyclicBarrier(N);//可以重用

            for(int i=0;i<N;i++) {
                new Writer(barrier).start();  //
            }

//            try {
//                Thread.sleep(25000);    //主线程等待25秒，这个时间主线程等待所有子线程执行完，才可以保证最后输出CyclicBarrier结束
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

//            System.out.println("CyclicBarrier重用");
//
//            for(int i=0;i<N;i++) {
//                new Writer(barrier).start();
//            }

            System.out.println("CyclicBarrier结束");//这个是主线程执行的，主线程不一定等子线程执行完,线程之间执行是独立的。
        }
        static class Writer extends Thread{
            private CyclicBarrier cyclicBarrier;
            public Writer(CyclicBarrier cyclicBarrier) {
                this.cyclicBarrier = cyclicBarrier;
            }

            @Override
            public void run() {
                System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
                try {
                   // Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                    System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");

                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }catch(BrokenBarrierException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"所有线程写入完毕，继续处理其他任务...");
            }
        }
    }
