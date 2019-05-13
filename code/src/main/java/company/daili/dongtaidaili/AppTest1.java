package company.daili.dongtaidaili;

import company.daili.jingtai.AppTest;
import company.daili.jingtai.IUserDao;
import company.daili.jingtai.UserDaoImply;
import company.fanxing.super1.Apple;

import java.util.LinkedList;
import java.util.List;

public class AppTest1 {
    public static void main(String[] args){
        String s = new String("a");
//        LinkedList<String> list =new LinkedList<>();
//        System.out.println(list.getClass().getClassLoader().toString());//sun.misc.Launcher$AppClassLoader@18b4aac2

      //  System.out.println(s.getClass().getClassLoader().toString());
      //  System.out.println(s.getClass().getClassLoader().getParent().toString());

        AppTest1 appTest1 =new AppTest1();
        System.out.println("apptest");
        System.out.println(appTest1.getClass().getClassLoader().toString());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(appTest1.getClass().getClassLoader().getParent().toString());//sun.misc.Launcher$ExtClassLoader@69663380
        IUserDao iUserDao = new UserDaoImply();

        ProxyFactory userDaoProxy = new ProxyFactory(iUserDao);
        IUserDao iUserDao1 = (IUserDao) userDaoProxy.getProxyInstance();
        iUserDao1.save(1);
    }
}
