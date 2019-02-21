package company.daili.dongtaidaili;

import company.daili.jingtai.IUserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        ClassLoader classLoader = target.getClass().getClassLoader();
        System.out.println(classLoader);

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始提交事务");
                Object proxy1 = method.invoke(target,args);
                System.out.println("结束提交事务");
                return proxy1;
            }
        });
    }

}
