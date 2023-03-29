package company.staticTest;

/**
 * @description 类的初始化，是根据静态变量和静态代码块的先后顺序来的
 * @author zhou
 * @date 2023/3/14~11:35
 */
public class StaticTest {
    /**
     * public class StaticTest {
     *     <clinit>(){
     *         a = 110;    // 实例变量
     *         System.out.println("2");        // 实例代码块
     *         System.out.println("3");     // 实例构造器中代码的执行
     *         System.out.println("a=" + a + ",b=" + b);  // 实例构造器中代码的执行
     *         类变量st被初始化
     *         System.out.println("1");        //静态代码块
     *         类变量b被初始化为112
     *     }
     * }
     *
     */
    public static void main(String[] args) {
        staticFunction();
    }


    /**
     * 先执行这个，clinit
     * 实际上是把实例初始化嵌入到了静态初始化流程中，并且在上面的程序中，
     * 嵌入到了静态初始化的起始位置。这就导致了实例初始化完全发生在静态初始化之前，当然，这也是导致a为110 b为0的原因。
     */
    static StaticTest st = new StaticTest();

    static {   //静态代码块
        System.out.println("1");
        //b静态变量放在静态代码块后面，会报错，引不到
        // System.out.println(b);
    }

    {       // 实例代码块
        System.out.println("2");
    }

    StaticTest() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }
    //不调用不会执行
    public static void staticFunction1() {   // 静态方法
        System.out.println("999");
    }


    int a = 110;    // 实例变量
    static int b = 112;     // 静态变量--类初始化（按照静态代码的顺序来）
}

/**
 * 类初始化的时机：
 * 　1) 遇到new、getstatic、putstatic或invokestatic这四条字节码指令（注意，newarray指令触发的只是数组类型本身的初始化，而不会导致其相关类型的初始化，比如，new String[]只会直接触发String[]类的初始化，也就是触发对类[Ljava.lang.String的初始化，而直接不会触发String类的初始化）时，如果类没有进行过初始化，则需要先对其进行初始化。生成这四条指令的最常见的Java代码场景是：
 * 使用new关键字实例化对象的时候；
 *
 * 读取或设置一个类的静态字段（被final修饰，已在编译器把结果放入常量池的静态字段除外）的时候；
 *
 * 调用一个类的静态方法的时候。
 *
 * 　　2) 使用java.lang.reflect包的方法对类进行反射调用的时候，如果类没有进行过初始化，则需要先触发其初始化。
 *
 * 　　3) 当初始化一个类的时候，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
 *
 * 　　4) 当虚拟机启动时，用户需要指定一个要执行的主类（包含main()方法的那个类），虚拟机会先初始化这个主类。
 *
 * 　　5) 当使用jdk1.7动态语言支持时，如果一个java.lang.invoke.MethodHandle实例最后的解析结果REF_getstatic,REF_putstatic,REF_invokeStatic的方法句柄，并且这个方法句柄所对应的类没有进行初始化，则需要先出触发其初始化
 *

 3、被动引用的几种经典场景
 　1)、通过子类引用父类的静态字段，不会导致子类初始化
 　2)、通过数组定义来引用类，不会触发此类的初始化
  3)、常量(final)在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
 *
 */

/**
 2
 3
 a=110,b=0
 1
 4
 */
