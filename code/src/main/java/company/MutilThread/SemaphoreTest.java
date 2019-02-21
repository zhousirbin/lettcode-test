package company.MutilThread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
 public static void main(String[] args){

     int N=4;
     Semaphore semaPhore = new Semaphore(N);

     for(int i=0;i<N;i++){
        Thread a = new Thread(new Worker(i,semaPhore));
        a.start();

     }
 }

 static class Worker implements Runnable{
     private int num;
     private Semaphore semaphore;
     private Worker(int num,Semaphore semaphore){
         this.num=num;
         this.semaphore = semaphore;
     }
     public void run(){

         try {
             semaphore.acquire();
             System.out.println("工人"+this.num+"占用一个机器在生产...");
             Thread.sleep(2000);

         System.out.println("工人"+this.num+"释放出机器");
         semaphore.release();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}
