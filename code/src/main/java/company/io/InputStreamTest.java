package company.io;

import java.io.*;

public class InputStreamTest {

    public static void main(String[] args){

        File file = new File("/Users/didi/zhou.txt");
        try {
            DataOutputStream dataOutputStream =  new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeByte(23);
            dataOutputStream.writeChars("zhouzhanyong");
            dataOutputStream.writeUTF("abcdefghijklmnopqrstuvwxyz严12");
           // dataOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(file));
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readByte());
            System.out.println(dataInputStream.readChar());
//            System.out.println(dataInputStream.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader d  = null;
        try {
            d = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {

            String a = null;
            System.out.println("开始");
              while ( (a=d.readLine())!=null){
                  System.out.println(a);
              }

            System.out.println("结束");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Reader reader = new InputStreamReader(new FileInputStream(file));

            System.out.println(reader.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            StringBuffer buffer = new StringBuffer();
            String line = " ";
            while ((line = in.readLine()) != null){
                buffer.append(line);
            }
            System.out.println(buffer.toString()); ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int i = '1';
        System.out.println(i);
    }
}
