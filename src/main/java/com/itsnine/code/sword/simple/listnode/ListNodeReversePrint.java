package com.itsnine.code.sword.simple.listnode;


import com.itsnine.code.sword.base.ListNode;

import java.util.Objects;

/**
 * 链表反转打印
 * 由于java中数组为定常数组，需先计算链表的长度
 * <p>
 * pit：
 * 1.不能利用ArrayList先存储数组，会导致内存超出限制
 * 2.需使用临时链表 计算链表长度，堆引用会导致链表已走到末尾无法重置
 *
 * @author xu.sun
 * @create 2021-08-04-8:09 下午
 */
public class ListNodeReversePrint {

    public int[] resolve(ListNode node) {
        ListNode head = node;
        int count = 0;

        while (Objects.nonNull(head)) {
            count++;
            head = head.next;
        }
        int[] array = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            array[i] = node.val;
            node = node.next;
        }

        return array;
    }
}
