package com.itsnine.code.sword.simple.string;

/**
 * 替换字符串中的空格
 * @author xu.sun
 * @create 2021-08-04-7:48 下午
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        System.out.println(resolveReplace("wo shi"));
    }

    /**
     * 库函数 s.replaceAll(regex,replacement)
     * @param s
     * @return
     */
    private static String resolveReplace(String s){
        return s.replaceAll(" ","%20");
    }

    /**
     * 循环遍历
     * @param s
     * @return
     */
    public String resolveReplaceTwo(String s){
        StringBuilder builder = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' '){
                builder.append("%20");
            }else {
                builder.append(c);
            }
        }

        return builder.toString();
    }

}
