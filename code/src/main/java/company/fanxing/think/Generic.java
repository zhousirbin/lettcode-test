package company.fanxing.think;

import lombok.extern.slf4j.Slf4j;

//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
@Slf4j
public class Generic<T>{
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    public static void showKeyValue(Generic<Number> obj){
        log.info("泛型测试","key value is " + obj.getKey());
    }

    /**
     * 如何解决上面的问题？总不能为了定义一个新的方法来处理Generic<Integer>类型的类，
     * 这显然与java中的多台理念相违背。因此我们需要一个在逻辑上可以表示同时是Generic<Integer>和Generic<Number>父类的引用类型。
     * 由此类型通配符应运而生。
     */
    // showKeyValue(gInteger); --会报错，报不匹配Number类型

    /**
     * 类型通配符一般是使用？代替具体的类型实参，注意了，此处’？’是类型实参，而不是类型形参 。
     * 重要说三遍！此处’？’是类型实参，而不是类型形参 ！ 此处’？’是类型实参，而不是类型形参 ！
     * 再直白点的意思就是，此处的？和Number、String、Integer一样都是一种实际的类型，可以把？看成所有类型的父类。是一种真实的类型。
     *
     * 可以解决当具体类型不确定的时候，这个通配符就是 ?  ；
     * 当操作类型时，不需要使用类型的具体功能时，只使用Object类中的功能。那么可以用 ? 通配符来表未知类型。
     */
    public static void showKeyValue1(Generic<?> obj){
        log.info("泛型测试","key value is " + obj.getKey());
    }


    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }
    /**
     * 这样也可以
     */
    public <E> E genericMethod1(Class<E> tClass)throws InstantiationException ,
            IllegalAccessException{
        E instance = tClass.newInstance();
        return instance;
    }


    //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
    public void showKeyValue2(Generic<Number> obj){
        log.info("泛型测试","key value is " + obj.getKey());
    }

    //这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
    //同时这也印证了泛型通配符章节所描述的，?是一种类型实参，可以看做为Number等所有类的父类
    public void showKeyValue3(Generic<?> obj){
        log.info("泛型测试","key value is " + obj.getKey());
    }

    /**
     * 这个方法也是有问题的，编译器会为我们提示错误信息："UnKnown class 'T' "
     * 对于编译器来说T这个类型并未项目中声明过，因此编译也不知道该如何编译这个类。
     * 所以这也不是一个正确的泛型方法声明。
     *
     * 后面发现，没有问题呀
     */
    public void showkey(T genericObj){
    }

    // 一个泛型方法和可变参数的例子
    public <T> void printMsg( T... args){
        for(T t : args){
            log.info("泛型测试","t is " + t);
        }
    }

    /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如：public static void show(T t){..},此时编译器会提示错误信息：
     "StaticGenerator cannot be refrenced from static context"
     */
    public static <T> void show(T t){

    }

    public static void main(String[] args) {
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);


        //1.泛型类型，不支持父子类型
        showKeyValue(gNumber);
        //会报错，说需要的是Number类型的
        // Generic<Number>和Generic<Ingeter>是否可以看成具有父子关系的泛型类型呢？ 答案是不可以
        // showKeyValue(gInteger);

        //2变成通配符后可以
        showKeyValue1(gNumber);
        showKeyValue1(gInteger);
    }


}
