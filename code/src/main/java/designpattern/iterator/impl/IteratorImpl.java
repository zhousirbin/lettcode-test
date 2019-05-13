package designpattern.iterator.impl;

import designpattern.iterator.Iterator;

public class IteratorImpl<Item> implements Iterator<Item> {

    private Item[] items;
    private int position;

    public IteratorImpl(Item[] items){ //如果不添加构造函数，会默认加一个空构造函数
       this.items = items;
    }

    public IteratorImpl() {  //如果定义了，包含参数的构造函数，那么需要加一个无参的构造函数

    }

    @Override
    public Item next() {
        return items[position++];
    }

    @Override
    public boolean hasNext() {
        return position < items.length;
    }
}
