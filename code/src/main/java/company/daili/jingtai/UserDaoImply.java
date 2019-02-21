package company.daili.jingtai;

public class UserDaoImply implements IUserDao{
    public void save(int i){
        System.out.println("准备保存数据"+i);
    }
}
