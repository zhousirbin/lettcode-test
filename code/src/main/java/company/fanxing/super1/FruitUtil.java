package company.fanxing.super1;

import java.util.List;

public class FruitUtil {

    public static  <T> void add(List<T> list ,T t){
        list.add(t);
    }

    public static <T> T  readFirst(List<? extends T> list){
        return list.get(0);
    }
}
