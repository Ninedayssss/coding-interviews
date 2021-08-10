package com.itsnine.code.sword.middle.search;

import com.itsnine.code.sword.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历变种题
 * 从上到下
 * 第一层从左到右，第二层从右到左，以此类推
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * @author xu.sun
 * @create 2021-08-10-9:35 下午
 */
public class ChangePrintlnTreeNode {

    /**
     * 使用双向链表控制进入链表的位置，从而控制打印的顺序
     * 结果list的size 可以得知当前循环所处的层级
     *
     * @param root
     * @return
     */
    public List<List<Integer>> resolve(TreeNode root) {
        //初始化queue
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        List<List<Integer>> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            //创建临时双向链表
            LinkedList<Integer> tmp = new LinkedList<>();
            //此时已知当前层数的节点数量，进行遍历即可得知本层的节点值。
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                //结果list的size可表明已经添加了多少层，由此可知当前循环的层级
                //偶数层-》添加至链表尾部 实现从左至右打印
                if (list.size() % 2 == 0) tmp.addLast(node.val);
                    //奇数层-》添加至链表首部，实现从右至左打印
                else tmp.addFirst(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(tmp);
        }
        return list;
    }
}
