package designpattern.observer.impl;

import designpattern.observer.Observer;

public class ObserverImpl1 implements Observer {
    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println(temp+humidity+"1111");
    }
}
