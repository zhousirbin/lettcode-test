package company.design.proxy;

/**
 * 代理模式：给某一个对象提供一个代理或占位符，并由代理对象来控制对原对象的访问。
 * 技术是一样的，代理和特性增强两个应用场景使两者有区别。比如decorator可以多层装饰，代理一般就一层
 * 装饰模式的功能实现是由上层调用者决定的，代理模式的功能已经写死了，不能够实现灵活的拓展
 */
public class ProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.Request();
        RealSubject realSubject = proxy.realSubject;

        RealSubject commSubject1 = proxy.realSubject1;


        Proxy proxy1 = new Proxy();
        RealSubject realSubject1 = proxy1.realSubject;

        RealSubject commSubject2 = proxy1.realSubject1;
        RealSubject commSubject3 = Proxy.realSubject1;
        //如果更改了，所有对象都会改
        commSubject2.setName("wo");
        proxy.Request();

    }

}

//目标抽象类
abstract class Subject
{
    public abstract void Request();
}

// 代理类
class Proxy extends Subject {
    //如果是静态的，就是所有对象共用
    public static RealSubject realSubject1 = new RealSubject("zhou"); //维持一个对真实主题对象的引用

    // 每创建一个对象，都会新增一个，都是新的
    public  RealSubject realSubject = new RealSubject("zhou"); //维持一个对真实主题对象的引用

    public void PreRequest(){
        //一些前置业务逻辑
        System.out.println("前置处理");

    }

    @Override
    public void Request() {
        PreRequest();
        realSubject.Request();
    }
}

//实现类
class RealSubject extends Subject {
    private String name;
    public RealSubject(String name){
        this.name = name;
    }
    public  void Request() {
        System.out.println("aaaa");
        //业务方法具体实现代码
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}