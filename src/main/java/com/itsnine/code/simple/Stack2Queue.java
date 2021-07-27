package com.itsnine.code.simple;

import java.util.LinkedList;

/**
 * 两个栈来实现一个队列，append入队列尾部，delete删除队列首部
 * <p>栈：先入后出</p>
 * <p>队列：先入先出</p>
 *
 * 时间复杂度：addTail O(1)
 *           deleteHead O(n)
 * 空间复杂度：a栈与b栈最大数量为N O(N)
 *
 * @author xu.sun
 * @create 2021-07-27-10:32 下午
 */
class Stack2Queue {
    LinkedList<Integer> a,b;
   public Stack2Queue(){
    a = new LinkedList<>();
    b = new LinkedList<>();
    }

    public void appendTail(int value){
       // a栈尾部加入
       a.addLast(value);
    }

    public int deleteHead(){
       //b栈不为空，移除b栈的尾部
       while (!b.isEmpty()){
           return b.removeLast();
       }
       //a栈为空且b栈为空，返回-1
       while (a.isEmpty()){
           return -1;
       }
        //a栈不为空，将a栈的尾部移除，插入b栈的尾部，实现将a栈倒序
       while (!a.isEmpty()){
           b.addLast(b.removeLast());
       }
       return b.removeLast();
    }
}
