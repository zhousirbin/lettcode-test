package company.daili.dongtaidaili;

import company.daili.jingtai.IUserDao;
import company.daili.jingtai.UserDaoImply;

public class AppTest1 {
    public static void main(String[] args){
        IUserDao iUserDao = new UserDaoImply();
        ProxyFactory userDaoProxy = new ProxyFactory(iUserDao);
        IUserDao iUserDao1 = (IUserDao) userDaoProxy.getProxyInstance();
        iUserDao1.save(1);
    }
}
