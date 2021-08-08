package com.itsnine.code.sword.middle.listnode;

import com.itsnine.code.sword.base.RandomNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 复杂链表复制
 * 节点包含random指针，random指针指向链表任意节点或null
 *
 * @author xu.sun
 * @create 2021-08-08-11:24 上午
 */
public class CopyRandomListNode {
    /**
     * 正常链表复制遍历即可获取新的链表
     * 由于包含random指针，复制时无法复制random指向的节点
     *
     * @param head
     * @return
     */
    public RandomNode resolve(RandomNode head) {
        if (Objects.isNull(head)) return null;

        RandomNode cur = head;
        //Map<旧节点，新节点>，复制各个节点map存储，建立旧节点->新节点映射
        Map<RandomNode, RandomNode> map = new HashMap<>();
        while (Objects.nonNull(cur)) {
            map.put(cur, new RandomNode(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (Objects.nonNull(cur)) {
            //第二次遍历，设置新节点的next节点及random节点
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
