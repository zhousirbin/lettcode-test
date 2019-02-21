package company.io;

import java.io.*;

public class InputStream1 {


    public static void main(String[] args) {
        File file = new File("/Users/didi/zhou1.txt");

        DataInputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            outputStream = new DataOutputStream(new FileOutputStream(file));
            outputStream.write('a');
            outputStream.write(new byte[]{1,0});
            inputStream = new DataInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (inputStream.read()!=-1){
                int b = inputStream.readChar();
                int a = inputStream.read();

                System.out.println(a);
                System.out.println(b);
            }



           inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            /* 写入Txt文件 */
            File writename = new File("/Users/didi/zhou2.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write("我会写入文件啦\r\n"); // \r\n即为换行
            out.write("我会写入文件啦111\r\n"); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件

            /* 读入TXT文件 */
            String pathname = "/Users/didi/zhou2.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
           // System.out.println(line);
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
                System.out.println(line);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
