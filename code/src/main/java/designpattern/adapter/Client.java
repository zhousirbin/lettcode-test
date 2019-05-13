package designpattern.adapter;

import designpattern.adapter.impl.TurkeyImpl;
import designpattern.adapter.impl.TurkeyImplAdapter;

public class Client {

    public static void main(String[] args) {
        Turkey turkey = new TurkeyImpl();
        Duck duck = new TurkeyImplAdapter(turkey);
        duck.quack();
    }
}
