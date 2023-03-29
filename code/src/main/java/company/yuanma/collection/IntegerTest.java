package company.yuanma.collection;

public class IntegerTest {

    public static void main(String[] args){

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d= 3;
        Integer w =322;
        Integer e= 321;
        Integer f= 321;
        Long  g = 3L;
        System.out.println(c==d); //等于
        System.out.println(e==f); //不等于
        System.out.println(c==(a+b));//等于
        System.out.println(c.equals(a+b));//等于
        System.out.println(g.equals(a+b));//false---只能同类型比较
        System.out.println(g==(a+b));//等于

        System.out.println(w.equals(e+a));//true //比较的的是int值





    }

}
