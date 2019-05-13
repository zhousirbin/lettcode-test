package company.annotion;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface FieldAnnotion {

    String type() default "ignore";
    int age() default 27;
    String hobby() default "no"; //没有指定defalut的，需要在注解的时候显式指明
}
