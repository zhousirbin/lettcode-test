package company.daili.jingtai;

public class UserDaoProxy implements IUserDao {

    private IUserDao target;
    public UserDaoProxy(IUserDao target){
        this.target = target;

    }
    public void save(int i){

        System.out.println("执行之前进行");
        target.save(i);
        System.out.println(System.currentTimeMillis());

    }
}
