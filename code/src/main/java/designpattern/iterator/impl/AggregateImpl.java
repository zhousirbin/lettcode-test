package designpattern.iterator.impl;

import designpattern.iterator.Aggregate;
import designpattern.iterator.Iterator;

public class AggregateImpl implements Aggregate {

    private Integer[] items;
    public AggregateImpl(){
        items = new Integer[10];
        for (int i = 0; i < items.length; i++) {
            items[i] = i;
        }

    }


    @Override
    public Iterator createIterator() {
        return new IteratorImpl<Integer>(items);  //创建迭代器
    }
}
