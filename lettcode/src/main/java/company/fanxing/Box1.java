package company.fanxing;

public class Box1{


    public <T> T getT3(T t){
        return t;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Box1 box1 = new Box1();
        Object o = box1.getT3(Object.class);
        System.out.println(o);

        Object o1 =box1.getT3(String.class);

        String a = box1.getT3(String.class).newInstance();
        System.out.println();

        String a1 = String.class.newInstance();
        ClassLoader classLoader = String.class.getClassLoader();
System.out.println(classLoader);
         System.out.println(box1.getT3(String.class));;
    }


}
