package com.itsnine.code.sword.simple.listnode;

import com.itsnine.code.sword.base.ListNode;

import java.util.Objects;

/**
 * 两个递增链表合并为一个递增链表
 * <p>
 * 时间复杂度O(M+N)
 * 空间复杂度O(1)
 *
 * @author xu.sun
 * @create 2021-08-04-8:55 下午
 */
public class MergeTwoListNodes {

    /**
     * 链表遍历
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode resolve(ListNode l1, ListNode l2) {
        //新建cur节点，否则结果node节点已遍历至末尾无法输出结果。
        //初始化链表第一个节点为0，结果返回合并链表的next即可解决链表初始化问题
        ListNode node = new ListNode(0), cur = node;

        //l1与l2节点均不为空，进行比较值大小
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            //l1小于l2节点 添加l1至合并链表 l1节点后移
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                //否则l2节点添加至合并链表，l2后移
                cur.next = l2;
                l2 = l2.next;
            }
            //合并链表后移，下一次next节点添加
            cur = cur.next;

        }

        //当存在1个链表为空时，将另外一个链表直接添加至合并链表
        cur.next = Objects.nonNull(l1) ? l1 : l2;
        return node.next;
    }
}
