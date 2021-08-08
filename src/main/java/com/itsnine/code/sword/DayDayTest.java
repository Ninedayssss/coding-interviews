package com.itsnine.code.sword;

import com.itsnine.code.sword.base.ListNode;

import java.util.Objects;

/**
 * @author xu.sun
 * @create 2021-08-05-10:32 下午
 */
public class DayDayTest {
    /**
     * 从尾到头打印链表
     *
     * @param node
     * @return
     */
    public int[] reservePrint(ListNode node) {
        int count = 0;
        ListNode tmp = node;
        while (Objects.nonNull(tmp)) {
            count++;
            tmp = tmp.next;
            System.out.println();
        }
        int[] array = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            array[i] = node.val;
            node = node.next;
        }
        return array;
    }

    public String replaceSpace(String s){
        return s.replaceAll(" ","%20");
    }


}
