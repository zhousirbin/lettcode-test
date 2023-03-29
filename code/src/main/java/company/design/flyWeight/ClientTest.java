package company.design.flyWeight;

import java.util.Hashtable;

/**
 * 需要一个工厂类，负责产出同一个对象
 * 需要一个抽象类，定义享元抽象类
 * 需要具体实现类，实现享元抽象类
 *
 */
class ClientTest {
    public static void main(String args[]) {
        IgoChessman black1,black2,black3,white1,white2;
        IgoChessmanFactory factory;

        //获取享元工厂对象
        factory = IgoChessmanFactory.getInstance();

        //通过享元工厂获取三颗黑子
        black1 = factory.getIgoChessman("b");
        black2 = factory.getIgoChessman("b");
        black3 = factory.getIgoChessman("b");
        System.out.println("判断两颗黑子是否相同：" + (black1==black2));

        //通过享元工厂获取两颗白子
        white1 = factory.getIgoChessman("w");
        white2 = factory.getIgoChessman("w");
        System.out.println("判断两颗白子是否相同：" + (white1==white2));

        //显示棋子，同时设置棋子的坐标位置
        black1.display(new Coordinates(1,2));
        black2.display(new Coordinates(3,4));
        black3.display(new Coordinates(1,3));
        white1.display(new Coordinates(2,5));
        white2.display(new Coordinates(2,4));

        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        getQuick(arr, 0, 5);



        System.out.println("排序后的数组：");
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
    }

    public static void  getQuick(int[] arr, int left , int right){
        if (left < right){
            int mid = getMiddle(left, right, arr);
            //回溯
            getQuick(arr, left, mid-1);
            getQuick(arr, mid+1, right);
        }

    }

   static int getMiddle(int left, int right, int[] arr){
        int temp = arr[left];
        while (left < right){
            while (left < right && temp < arr[right]){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && temp > arr[left]){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }
}

//围棋棋子类：抽象享元类--不带外部状态
//abstract class IgoChessman {
//    //抽象方法，子类去实现
//    public abstract String getColor();
//
//    public void display() {
//        System.out.println("棋子颜色：" + this.getColor());
//    }
//}

//黑色棋子类：具体享元类
class BlackIgoChessman extends IgoChessman {
    public String getColor() {
        return "黑色";
    }
}

//白色棋子类：具体享元类
class WhiteIgoChessman extends IgoChessman {
    public String getColor() {
        return "白色";
    }
}

//围棋棋子工厂类：享元工厂类，使用单例模式进行设计
class IgoChessmanFactory {
    private static IgoChessmanFactory instance = new IgoChessmanFactory();
    private static Hashtable ht; //使用Hashtable来存储享元对象，充当享元池

    private IgoChessmanFactory() {
        ht = new Hashtable();
        IgoChessman black,white;
        black = new BlackIgoChessman();
        ht.put("b",black);
        white = new WhiteIgoChessman();
        ht.put("w",white);
    }

    //返回享元工厂类的唯一实例
    public static IgoChessmanFactory getInstance() {
        return instance;
    }

    //通过key来获取存储在Hashtable中的享元对象
    public static IgoChessman getIgoChessman(String color) {
        return (IgoChessman)ht.get(color);
    }
}

//坐标类：外部状态类--可变的
class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

//围棋棋子类：抽象享元类
abstract class IgoChessman {
    public abstract String getColor();

    //很关键，需要引入可变状态, 作为入参注入
    public void display(Coordinates coord){
        System.out.println("棋子颜色：" + this.getColor() + "，棋子位置：" + coord.getX() + "，" + coord.getY() );
    }
}