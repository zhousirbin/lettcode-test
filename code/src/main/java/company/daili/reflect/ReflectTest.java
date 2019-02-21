package company.daili.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectTest {
    public static void main(String[] args){
        List list = new ArrayList();
        try {
            Class class2 =Class.forName("java.util.ArrayList");
            System.out.println("ClassLoader1"+"  "+class2.getClassLoader());
            System.out.println(class2);
            Field[] fields = class2.getDeclaredFields();
            for (Field field:fields
                    ) {
                System.out.println(field);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Class class1 =Class.forName("company.daili.CglibProxy.AppleDao");//需要加上一个包名
            ;
            System.out.println("ClassLoader"+"  "+class1.getClassLoader());
            Field[] fields = class1.getDeclaredFields();
            try {
                Method method = class1.getDeclaredMethod("eat",null);//后面接形参参数类型
                System.out.println("method"+" "+method);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            for (Field field:fields
                 ) {
                System.out.println(field);
            }
            System.out.println(class1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
