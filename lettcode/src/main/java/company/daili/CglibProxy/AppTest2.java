package company.daili.CglibProxy;



public class AppTest2 {
    public static void main(String[] args){
        AppleDao iUserDao = new AppleDao();

        ProxyFactory1 userDaoProxy = new ProxyFactory1(iUserDao);

        AppleDao iUserDao1 = (AppleDao) userDaoProxy.getProxyInstance();
        iUserDao1.eat();
    }
}
