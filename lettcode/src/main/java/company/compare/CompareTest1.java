package company.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CompareTest1 {
    public static void main(String[] args) {
        List<UserInfo> list = new ArrayList<UserInfo>();
        list.add(new UserInfo(1,21,"name1"));
        list.add(new UserInfo(2,27,"name2"));
        list.add(new UserInfo(3,15,"name3"));
        list.add(new UserInfo(5,24,"name4"));
        list.add(new UserInfo(4,24,"name5"));
        //new一个比较器
        MyComparator comparator = new MyComparator();
        //对list排序
        Collections.sort(list,comparator);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}

class MyComparator implements Comparator<UserInfo>{
    @Override
    public int compare(UserInfo o1,UserInfo o2) {

        if(o1.getAge()-o2.getAge()==0){
            return o1.getUserid()-o2.getUserid();  //如果返回值大于0；则o1大于o2
        }else{
            return o1.getAge()-o2.getAge();
        }
    }
}

class UserInfo{
    private int userid;
    private int age;
    private String name;
    public UserInfo(int userid, int age, String name) {
        this.userid = userid;
        this.age = age;
        this.name = name;
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return this.userid+","+this.age+","+this.name;
    }
}

