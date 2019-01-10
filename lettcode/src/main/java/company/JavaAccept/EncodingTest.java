package company.JavaAccept;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EncodingTest {

    public static void main(String[] args) {
        String s1 = "中国";
       System.out.println(getEncoding(s1));
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("/Users/didi/wget-log");



            byte[] data = new byte[1024];

            //当前下标

            int i = 0;

            //读取流中的第一个字节数据

            int n = fis.read();

            //依次读取后续的数据

//未到达流的末尾

            while(n != -1){

                //将有效数据存储到数组中

                data[i] = (byte)n;
                System.out.println(data[i]);

                //下标增加

                i++;

                //读取下一个字节的数据

                n = fis.read();

            }



            //解析数据

            String s = new String(data,0,i);

            //输出字符串

            System.out.println(s);

        }catch(Exception e){

            e.printStackTrace();

        }finally {

            try {

                //关闭流，释放资源

                fis.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }

}
