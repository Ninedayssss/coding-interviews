package com.itsnine.code.sword.base;

/**
 * 复杂链表
 * random指针指向链表任意一个节点或null
 * @author xu.sun
 * @create 2021-08-08-11:25 上午
 */
public class RandomNode {
   public int val;
   public RandomNode next;
   public RandomNode random;

   public RandomNode(int val){
       this.val = val;
       this.next = null;
       this.random = null;
   }
    public RandomNode(int val, RandomNode next, RandomNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
