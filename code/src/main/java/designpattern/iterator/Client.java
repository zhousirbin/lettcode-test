package designpattern.iterator;

import designpattern.iterator.impl.AggregateImpl;
import designpattern.iterator.impl.IteratorImpl;

public class Client {

    public static void main(String[] args){

        Aggregate aggregate = new AggregateImpl();
       // Iterator iterator1 = new IteratorImpl();
        Iterator iterator   = aggregate.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


}
