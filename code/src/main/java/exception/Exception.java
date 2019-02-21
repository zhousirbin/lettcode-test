package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Exception {

    public static void main(String[] args){
        try {
            read("a");
//        } catch (FileNotFoundException e) {
//
//            System.out.println("***********");
//
       } catch (Throwable throwable) {
            Throwable se = throwable.getCause();
            se.printStackTrace();
            System.out.println(se.getMessage());
            System.out.println("1111111111");
            throwable.printStackTrace();
            System.out.println("222222");
        }

    }

    public static void read(String a) throws Throwable {

        try {
            InputStream inputStream = new FileInputStream("");
        } catch (FileNotFoundException e) {

            Throwable se = new FileNotFoundException("文件没有找到111");
            se.initCause(e);
            throw se;
        }
    }
}
