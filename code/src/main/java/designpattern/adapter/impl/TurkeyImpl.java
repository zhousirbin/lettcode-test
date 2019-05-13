package designpattern.adapter.impl;

import designpattern.adapter.Duck;
import designpattern.adapter.Turkey;

public class TurkeyImpl implements Turkey{


    @Override
    public void gobble() {
        System.out.println("huoji");
    }
}
