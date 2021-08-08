package com.itsnine.code.sword.simple.string;

/**
 * 左旋转指定数量的字符串
 * @author xu.sun
 * @create 2021-08-08-12:23 下午
 */
public class ReserveLeftWords {
    public static String resolve(String s,int k){
        String s1 = s.substring(0, k);
        String s2 = s.substring(k, s.length());
        String s3 = s2 + s1;
        return s3;
    }

    public static void main(String[] args) {
        resolve("123",2);
    }
}
