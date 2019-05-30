package company.sign;


import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

/**
 * 基于Commons Codec的Base64加密
 */
public class Base64Code {
    private static final String ENCODING = "UTF-8";

    /**
     * 一般Base64加密
     */
    public static String encode(String data) throws UnsupportedEncodingException{
        byte[] encodedByte = Base64.encodeBase64(data.getBytes(ENCODING));
        return new String(encodedByte, ENCODING);
    }

    /**
     * 安全Base64加密
     */
    public static String encodeSafe(String data) throws UnsupportedEncodingException{
        /*
         * 注意：这里采用的encodeBase64(byte[] bytes, boolean arg1)
         * arg1为true时，加密后的字符串每行为76个字符，不论每行够不够76个字符，都要在行尾添加“\r\n”
         */
        byte[] encodedByte = Base64.encodeBase64(data.getBytes(ENCODING),true);
        return new String(encodedByte, ENCODING);
    }

    /**
     * Base64解密
     */
    public static String decode(String data) throws UnsupportedEncodingException{
        byte[] decodedByte = Base64.decodeBase64(data.getBytes(ENCODING));
        return new String(decodedByte, ENCODING);
    }

    /**
     * 测试
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {


        String resourceKey = UUID.randomUUID().toString();
        System.out.println("UUid-->"+resourceKey);
        /********************测试一般encode*********************/
        String data = "去田园是我的梦 想！";
        System.out.println("原文-->"+data);
        String encodedStr = Base64Code.encode(data);
        System.out.println("加密后-->"+encodedStr);
        String decodedStr = Base64Code.decode(encodedStr);
        System.out.println("解密后-->"+decodedStr);
        System.out.println(data.equals(decodedStr));
        System.out.println("================================");
        /********************测试安全encode*********************/
        String data2 = "去田园是我的梦 想！去田园是我的梦 想！";
        System.out.println("原文-->"+data2);
        String encodedStr2 = Base64Code.encodeSafe(data2);
        System.out.println("加密后-->"+encodedStr2);
        String decodedStr2 = Base64Code.decode(encodedStr2);
        System.out.println("解密后-->"+decodedStr2);
        System.out.println(data2.equals(decodedStr2));
    }
}
