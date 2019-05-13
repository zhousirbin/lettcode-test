package company.yuanma.collection;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

    private static DelayQueue<MyDelayTask> delayQueue = new DelayQueue<>();

    public static void main(String[] args){

        System.out.println("start");


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                delayQueue.offer(new MyDelayTask("task1",10000));
                System.out.println("2");
                delayQueue.offer(new MyDelayTask("task2",3900));
                delayQueue.offer(new MyDelayTask("task3",1900));
                delayQueue.offer(new MyDelayTask("task4",5900));
                delayQueue.offer(new MyDelayTask("task5",6900));
                delayQueue.offer(new MyDelayTask("task6",7900));
                delayQueue.offer(new MyDelayTask("task7",4900));

            }
        }).start();

        while (true){

            MyDelayTask myDelayTask = null;
            try {
                myDelayTask = delayQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(myDelayTask);
        }

    }


}

class MyDelayTask implements Delayed{

    private String name;
    private long  time;
    private long start = System.currentTimeMillis();
    public MyDelayTask(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    //
    public long getDelay(TimeUnit unit) {
        return unit.convert(start+time-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int)this.getDelay(TimeUnit.MILLISECONDS)-(int)o.getDelay(TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return "MyDelayTask{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
