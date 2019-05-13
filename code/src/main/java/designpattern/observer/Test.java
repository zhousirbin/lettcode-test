package designpattern.observer;

import designpattern.observer.impl.ObserverImpl;
import designpattern.observer.impl.ObserverImpl1;
import designpattern.observer.impl.SubjectImpl;

public class Test {

    public static void  main(String[] args){

        SubjectImpl subject = new SubjectImpl();
        Observer observer = new ObserverImpl();
        Observer observer1 = new ObserverImpl1();
        subject.registerObserver(observer);
        subject.registerObserver(observer1);
        subject.setMeasurements(0,0,0);
        subject.setMeasurements(1,1,1);




    }



}
