package company.fanxing;



public class FanxingTest {

//    private static final Logger logger = LoggerFactory.getLogger(FanxingTest.class);
    public static void main(String[] args) {

        Box<Integer> box = new Box<>();
        Box<String>  box1 = new Box<>();

        box1.setObject("today");

        box.setObject(1);
        System.out.println(box.getObject());

        Util.Pair<Integer, String> p1 = new Util.Pair<>(1, "apple");
        Util.Pair<Integer, String> p2 = new Util.Pair<>(2, "pear");
        boolean same = Util.compare(p1, p2);

        System.out.println(same);


        String[] strings =  {"apple","apple1","apple2","apple3"};
        int a = Util.countGreaterThan(strings,"apple");
        int b = Util.coutThann(strings,"apple");


        System.out.println(a);

    }

}
