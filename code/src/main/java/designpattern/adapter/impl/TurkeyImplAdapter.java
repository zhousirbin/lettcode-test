package designpattern.adapter.impl;

import designpattern.adapter.Duck;
import designpattern.adapter.Turkey;

public class TurkeyImplAdapter implements Duck {

    // 鸭子（Duck）和火鸡（Turkey）拥有不同的叫声，Duck 的叫声调用 quack() 方法，而 Turkey 调用 gobble() 方法。

    // 要求将 Turkey 的 gobble() 方法适配成 Duck 的 quack() 方法，从而让火鸡冒充鸭子！
    private Turkey turkey;

    public TurkeyImplAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    @Override
    public void quack() {  //鸭子的叫声，但其实实现是火鸡的叫声

        System.out.println("yazishengyin");
        turkey.gobble(); //
    }






}
