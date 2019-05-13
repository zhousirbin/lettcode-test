package company.yuanma.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedList<E> {
     private static final long serialVersionUID = -817911632652898426L;

     final Object[] items;

     int takeIndex;

     int putIndex;

     int count;

     final ReentrantLock lock;

     private Condition notEmpty;

     private Condition notFull;

     public BlockedList(int capacity) {
         this(capacity,false);
    }
    public BlockedList(int capacity, boolean fair) {
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.items = new Object[capacity];
        lock = new ReentrantLock(fair);
        notEmpty = lock.newCondition();
        notFull =  lock.newCondition();
    }

    public E take(){



         return null;
    }

    public void  put(E e) throws InterruptedException {
         checkNull(e);
         final ReentrantLock lock = this.lock;
         lock.lockInterruptibly();
         try {
             while (items.length==count){
                 notFull.await();//队列满，线程等待，知道
             }
             enqueue(e);//激发not
         }finally {
             lock.unlock();
         }

    }

    public E  take(E e) throws InterruptedException {
        checkNull(e);
        final ReentrantLock reentrantLock = this.lock;
        lock.lockInterruptibly();
        try {
            while (items.length==0){
                notEmpty.await(); //没有数据，等待
            }
            return dequeue();//激发notFull,(可以put)
        }finally {
            lock.unlock();
        }

    }



    private void enqueue(E x) {
        final Object[] items = this.items;
        items[putIndex] = x;
        if (++putIndex == items.length)
            putIndex = 0;
        count++;
        notEmpty.signal();
    }



    private E dequeue() {
        final Object[] items = this.items;
        E x = (E) items[takeIndex];
        items[takeIndex] = null;
        if (++takeIndex == items.length)
            takeIndex = 0;
        count--;
        notFull.signal();
        return x;
    }


    private static void checkNull(Object v){

         if (v==null){
             throw new NullPointerException();
         }


    }


    public static void main(String[] args){

         Integer[] integers = {1,2,3};
         integers[2] = null;
         System.out.println(integers);


        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(8);


        BlockedList<String> blockedList = new BlockedList<>(7);

        try {
            blockedList.put("a");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}
