package company.annotion;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestOne {

    @FieldAnnotion(hobby = "ko" )
    private String maomao;

    @FieldAnnotion
    private String zhangwenping;

    @MethodAnnotion
    public void method1() {

    }
    @MethodAnnotion
    public void method2() {

    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 此处要用反射将字段中的注解解析出来
        Class<TestOne> clz = TestOne.class;
        // 判断类上是否有次注解
        boolean clzHasAnno = clz.isAnnotationPresent(TypeAnnotion.class);//此处没有注解
        if (clzHasAnno) {
            // 获取类上的注解
            FieldAnnotion annotation = clz.getAnnotation(FieldAnnotion.class);
            // 输出注解上的属性
            int age = annotation.age();
            String hobby = annotation.hobby();
            String type = annotation.type();
            System.out.println(clz.getName() + " age = " + age + ", hobby = " + hobby.toString() + " type = " + type);
        }

        //通过反射拿到类
        Class class2 =Class.forName("company.annotion.AnnotionTest");
        try {
            AnnotionTest annotionTest = (AnnotionTest )class2.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        boolean hasAnno =class2.isAnnotationPresent(TypeAnnotion.class);
        Field[] fields1 = class2.getDeclaredFields();


        // 解析字段上是否有注解
        // ps：getDeclaredFields会返回类所有声明的字段，包括private、protected、public，但是不包括父类的
        // getFields:则会返回包括父类的所有的public字段，和getMethods()一样
        Field[] fields = clz.getDeclaredFields();
        for(Field field : fields){
            boolean fieldHasAnno = field.isAnnotationPresent(FieldAnnotion.class);
            if(fieldHasAnno){
                FieldAnnotion fieldAnno = field.getAnnotation(FieldAnnotion.class);
                //输出注解属性
                int age = fieldAnno.age();
                String hobby = fieldAnno.hobby();
                String type = fieldAnno.type();
                System.out.println(field.getName() + " age = " + age + ", hobby = " + Arrays.asList(hobby).toString() + " type = " + type);
            }
        }



        //解析方法上的注解
        Method[] methods = clz.getDeclaredMethods();
        for(Method method : methods){
            boolean methodHasAnno = method.isAnnotationPresent(MethodAnnotion.class);
            if(methodHasAnno){
                //得到注解
                MethodAnnotion methodAnno = method.getAnnotation(MethodAnnotion.class);
                //输出注解属性
                String desc = methodAnno.desc();
                System.out.println(method.getName() + " desc = " + desc);
            }
        }
    }

}
