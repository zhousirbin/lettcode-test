package company.code.me;

public class Static {

    static int i =1;
    static {
        System.out.println("第一次"+i);
    }
    int b=2;
    static {
        i=0;
        System.out.println("第二次"+i);
    }
    public static void main(String[] args){


        if(true){
            System.out.println("true");
        }
        if (false){
            System.out.println("false");
        }
//        while (false){
//            System.out.println("zhu");
//        }
System.out.println("zhou");
System.out.println(i);
System.out.println();
    }


}
