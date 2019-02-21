package company.thread;

public class TestThreadWait {

    public static void main(String[] args) {

        /**
         * 定时任务，执行三次
         */
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int i =3;
                    while (i>0) {
                        i--;
                        System.out.println("开始");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    }
                    System.out.println("结束");

                }
            });
            thread.start();
        }
    }

