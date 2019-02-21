package company.MutilThread;



public class ThreadLocalTest  {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();//主线程和子线程分别有一份拷贝，互相不干扰。
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


    public void set() {
        long i = 1;
        longLocal.set(++i);
//        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public void set1() {
        long i = 1;
        ++i;
//        longLocal.set(Thread.currentThread().getId());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();


        test.set();
        System.out.println("主线程"+test.getLong());
        System.out.println("主线程"+test.getString());


        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println("子线程"+test.getLong());
                System.out.println("子线程"+test.getString());
            };
        };
        thread1.start();
        thread1.join();

//        System.out.println(test.getLong());
//        System.out.println(test.getString());
    }
}