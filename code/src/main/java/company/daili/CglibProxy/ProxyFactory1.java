package company.daili.CglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory1 implements MethodInterceptor{

    private Object target;

    public ProxyFactory1(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);

        System.out.println(enhancer);
        return enhancer.create();
    }

    //主要用于拦截具体调用的方法
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable{

        System.out.println("eat apple start");
        Object object1 = method.invoke(target,args);
        System.out.println("eat apple stop");
        return object1;
    }
}
