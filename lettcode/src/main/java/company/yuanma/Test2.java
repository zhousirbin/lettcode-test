package company.yuanma;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args){

        List list = new ArrayList();
        Class clazz = list.getClass();
        System.out.println(clazz);

        Class<?> cls = null; // 取得Class对象
        try {
            cls = Class.forName("java.util.ArrayList");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Object obj = cls.newInstance();
            System.out.println(obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
