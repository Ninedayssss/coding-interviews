package com.itsnine.code.sword.simple.listnode;

import com.itsnine.code.sword.base.ListNode;

import java.util.Objects;

/**
 * 反转链表
 * @author xu.sun
 * @create 2021-08-08-11:11 上午
 */
public class ReserveListNode {

    /**
     * 迭代反转链表
     * 通过指针指向改变链表方向
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public ListNode resolve(ListNode head){
        ListNode cur = head,pre=null;
        while (Objects.nonNull(cur)){
            //暂存后续所有节点
            ListNode tmp = cur.next;
            //修改后续引用的指向
            cur.next = pre;
            //将当前节点赋值给pre，暂存当前节点
            pre = cur;
            //访问下一节点
            cur = tmp;
        }
        return pre;
    }

}
