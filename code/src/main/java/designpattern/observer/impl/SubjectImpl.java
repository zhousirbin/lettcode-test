package designpattern.observer.impl;

import designpattern.observer.Observer;
import designpattern.observer.Subject;

import java.util.ArrayList;
import java.util.List;

//主要定义一些属性，以及观察者
public class SubjectImpl implements Subject {

    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    public SubjectImpl(){
        observers = new ArrayList<>();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
    }
    @Override
    public void registerObserver(Observer observer) {

        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {

        for (Observer observer :observers){
            observer.update(temperature, humidity, pressure); //更新这个对象的属性
        }
    }
}
