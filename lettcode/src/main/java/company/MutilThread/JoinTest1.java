package company.MutilThread;

public class JoinTest1 {
        public static void main(String[] args) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " start.");
            CustomThread2 t1 = new CustomThread2(); //子线程， CustomThread1需要等到CustomThread执行完，才会
            try {
                t1.start();
                System.out.println("主线程");
                t1.join();   //相当于t1参加到主线程里，进行。
                System.out.println("子线程结束后");//等待子线程执行完。
            } catch (Exception e) {
                System.out.println("Exception from main");
            }
            System.out.println(threadName + " end!");
        }
    }


class CustomThread2 extends Thread {
    public CustomThread2() {
        super("[CustomThread2] Thread");
    };
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " loop at " + i);
//                Thread.sleep(1000);
            }
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}