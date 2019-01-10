package company.daili.jingtai;

public class AppTest {
    public static void main(String[] args){
        IUserDao iUserDao = new UserDaoImply();
        UserDaoProxy userDaoProxy = new UserDaoProxy(iUserDao);
        userDaoProxy.save(1);
    }
}
