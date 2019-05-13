package company.fanxing;

import java.util.ArrayList;
import java.util.List;

public class Generic<T> {

        private T key;

        public Generic(T key) {
            this.key = key;
        }

        //我想说的其实是这个，虽然在方法中使用了泛型，但是这并不是一个泛型方法。
        //这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
        //所以在这个方法中才可以继续使用 T 这个泛型。
        public T getKey(){
            return key;
        }


        public void setKey(T key) {
            this.key = key;
        }

//        public <E> E setKey1(E v){
//            return v;
//        }

    //Generic<? super Integer>  Integer的父类
    //Generic<? extends Number>  Number的子类

    public static void showKeyValue1(Generic<? extends Number> obj){
        System.out.println("泛型测试key value is " + obj.getKey());
    }


    public static void main(String[] args){

            Generic<String> stringGeneric = new Generic<>("zhou");
            Generic<Integer> integerGeneric = new Generic<>(1);
            Generic<Number>  numberGeneric = new Generic<>(9);

            //stringGeneric.showKeyValue1();
            //showKeyValue1(stringGeneric);
            showKeyValue1(integerGeneric);
            showKeyValue1(numberGeneric);

        List<Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1235L);
        numbers.add(12.3);
        System.out.println(numbers);


    }

}
