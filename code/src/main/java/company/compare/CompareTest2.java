package company.compare;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class CompareTest2 {
    public static void main(String[] args) {
        List<UserInfo1> list = new ArrayList<UserInfo1>();
        list.add(new UserInfo1(1,21,"name1"));
        list.add(new UserInfo1(2,27,"name2"));
        list.add(new UserInfo1(3,15,"name1"));
        list.add(new UserInfo1(5,24,"nameb"));
        list.add(new UserInfo1(4,24,"name2"));
        //对该类排序
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}

class UserInfo1 implements Comparable<UserInfo1>{
    private int userid;
    private int age;
    private String name;
    public UserInfo1(int userid, int age, String name) {
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
    @Override
    public int compareTo(UserInfo1 o) {
        //如果年龄相同，则比较userid，也可以直接  return this.age-o.age;
        if(this.age-o.age==0){
           // return this.userid-o.userid;
            Collator instance = Collator.getInstance(Locale.ENGLISH);
            return instance.compare(this.name, o.name); //根据name排序
        }else{
            return this.age-o.age;
        }
    }

}
