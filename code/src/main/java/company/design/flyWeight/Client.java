package company.design.flyWeight;

import java.util.HashMap;

public class Client {
}

/**
 *   ● Flyweight（抽象享元类）：通常是一个接口或抽象类，在抽象享元类中声明了具体享元类公共的方法，这些方法可以向外界提供享元对象的内部数据（内部状态），同时也可以通过这些方法来设置外部数据（外部状态）。
 *
 *       ● ConcreteFlyweight（具体享元类）：它实现了抽象享元类，其实例称为享元对象；在具体享元类中为内部状态提供了存储空间。通常我们可以结合单例模式来设计具体享元类，为每一个具体享元类提供唯一的享元对象。
 *
 *       ● UnsharedConcreteFlyweight（非共享具体享元类）：并不是所有的抽象享元类的子类都需要被共享，不能被共享的子类可设计为非共享具体享元类；当需要一个非共享具体享元类的对象时可以直接通过实例化创建。
 *
 *       ● FlyweightFactory（享元工厂类）：享元工厂类用于创建并管理享元对象，它针对抽象享元类编程，将各种类型的具体享元对象存储在一个享元池中，享元池一般设计为一个存储“键值对”的集合（也可以是其他类型的集合），可以结合工厂模式进行设计；当用户请求一个具体享元对象时，享元工厂提供一个存储在享元池中已创建的实例或者创建一个新的实例（如果不存在的话），返回新创建的实例并将其存储在享元池中
 *
 *
 */
class FlyweightFactory {

    //定义一个HashMap用于存储享元对象，实现享元池
    private HashMap flyweights = new HashMap();

    public Flyweight getFlyweight(String key){

        //如果对象存在，则直接从享元池获取
        if(flyweights.containsKey(key)){
            return(Flyweight)flyweights.get(key);
        }
        //如果对象不存在，先创建一个新的对象添加到享元池中，然后返回
        else {
            Flyweight fw = new ConcreteFlyweight("aaa");
            flyweights.put(key,fw);
            return fw;
        }

    }

}

//享元类的设计是享元模式的要点之一，在享元类中要将内部状态和外部状态分开处理，通常将内部状态作为享元类的成员变量，
// 而外部状态通过注入的方式添加到享元类中。典型的享元类代码如下所示

class Flyweight {

    //内部状态intrinsicState作为成员变量，同一个享元对象其内部状态是一致的
    private String intrinsicState;

    public  Flyweight(String intrinsicState) {

        this.intrinsicState=intrinsicState;

    }

    //外部状态extrinsicState在使用时由外部设置，不保存在享元对象中，即使是同一个对象，在每一次调用时也可以传入不同的外部状态
    public void operation(String  extrinsicState) {

    }

}

class ConcreteFlyweight extends Flyweight {

    //内部状态intrinsicState作为成员变量，同一个享元对象其内部状态是一致的
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        super(intrinsicState);
        this.intrinsicState = intrinsicState;

    }

    //外部状态extrinsicState在使用时由外部设置，不保存在享元对象中，即使是同一个对象，在每一次调用时也可以传入不同的外部状态

    public void operation(String extrinsicState) {


    }
}
