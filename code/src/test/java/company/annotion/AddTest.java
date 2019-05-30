package company.annotion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.FrameworkMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AddTest {

    private static Calculator calculator = new Calculator();
    private int param;
    private int param1;
    private int result;

    public AddTest(int param,int param1, int result){
        this.param  = param;
        this.result = result;
        this.param1  = param1;
    }



    @Parameterized.Parameters
    public Collection da(){
        return Arrays.asList(new Object[][]{
                {1,2,3},
                {1,3,4},
                {1,4,5},
        });
    }
     @Test
    public void addTest(){
        calculator.add(param, param1);
        assertEquals(result,calculator.getResult());

    }


    @Test(expected = ArithmeticException.class) //如果不加这个，会抛出异常，java.lang.ArithmeticException: / by zero，用例不通过
    public void divideByZero(){
        calculator.divide(0);
    }


    public static Method[] getMethod(){

//        Method[] methods = AddTest.class.getDeclaredMethods();
//        Annotation[] annotations = AddTest.class.getAnnotations();
//        Parameterized.Parameters annotation = (Parameterized.Parameters.class);
//
//        Method[] me = annotation.annotationType().getDeclaredMethods();

//        AddTest anno = AddTest.class.getAnnotation(Test.class);
//
//        Method[] met = anno.annotationType().getDeclaredMethods();
//        if(anno != null){
//            Method[] met = anno.annotationType().getDeclaredMethods();
        return null;

    }

    public static void main(){

    }

}
