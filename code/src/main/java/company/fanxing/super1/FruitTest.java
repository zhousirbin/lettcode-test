package company.fanxing.super1;

import java.util.ArrayList;
import java.util.List;

public class FruitTest {

    public static void main(String[] args) {

        List<Apple> list =  new ArrayList<>();
        Apple apple = new Apple();
        Apple apple1 = new Apple();

        FruitUtil.add(list,apple);
        FruitUtil.add(list,apple1);

        System.out.println(list);

        List<Fruit> fruits =  new ArrayList<>();
        FruitUtil.add(fruits,apple);


        Orange orange = new Orange();

        FruitUtil.add(fruits,orange);

        Fruit fruit = new Fruit();
        FruitUtil.add(fruits,fruit);

        System.out.println(fruits);

        Fruit fruit1 = FruitUtil.readFirst(fruits);

        System.out.println(fruit1);

        System.out.println(FruitUtil.readFirst(fruits));



    }
}
