package company.annotion;



import java.util.LinkedList;


public class BlockedList<E> {

    private int capacity;

    private LinkedList<E> list;


    public BlockedList(int capacity) {
        this.capacity = capacity;
    }

    public E take(){
        return list.removeFirst();
    }

    public void add(E e){

      list.addLast(e);
    }


}
