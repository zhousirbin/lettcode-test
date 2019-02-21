package company.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTest1 {
//    public static void main(String[] args) {
//        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);
//        for (int i = 0; i < 10; ++i) {
//            executor.schedule(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + " run ");
//                }
//            } , 2 *i, TimeUnit.SECONDS);
//
//            //executor.scheduleAtFixedRate(task,第一次延时时间，每隔多长时间，单位);
//        }
//        executor.shutdown();
//    }

      public static void main(String[] args)
      {
          Runnable runnable = new Runnable() {
              @Override
              public void run() {
                  System.out.println("Task begin");
              }
          };

          ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
          int i=4;

           while (i>0){
             i--;
             executor.schedule(runnable,  3*i, TimeUnit.SECONDS); //初始延时秒

           }
          executor.shutdown();
         // executor.shutdown();
}


}
