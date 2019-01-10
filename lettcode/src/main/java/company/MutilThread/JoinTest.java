package company.MutilThread;

class CustomThread1 extends Thread {
    public CustomThread1() {
        super("[CustomThread1] Thread");
    };
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " loop at " + i);
                Thread.sleep(1000);
            }
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}
class CustomThread extends Thread {
    CustomThread1 t1;
    public CustomThread(CustomThread1 t1) {
        super("[CustomThread] Thread");
        this.t1 = t1;
    }
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");//这个不影响，会正常执行
        try {
            t1.join();
            System.out.println(threadName + " end.");//在子线程执行完，CustomThread才会执行
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}
public class JoinTest {
    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        CustomThread1 t1 = new CustomThread1(); //子线程， CustomThread1需要等到CustomThread执行完，才会执行
        CustomThread t = new CustomThread(t1); //父线程  ,父线程会等到子线程执行完，才会执行join后面的代码
        try {
            t1.start();
//            Thread.sleep(2000);
            t.start();
//            t.join();//在代碼2里，將此處注釋掉
        } catch (Exception e) {
            System.out.println("Exception from main");
        }
        System.out.println(threadName + " end!");
    }
}