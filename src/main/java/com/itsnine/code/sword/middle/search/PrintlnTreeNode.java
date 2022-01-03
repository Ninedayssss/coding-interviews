package com.itsnine.code.sword.middle.search;

import com.itsnine.code.sword.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历变种题
 * 从上到下，从左到右打印
 * 同层级的节点打印在一个数组
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * @author xu.sun
 * @create 2021-08-10-9:12 下午
 */
public class PrintlnTreeNode {
    public List<List<Integer>> resolve(TreeNode root) {
        //初始化queue
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        List<List<Integer>> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            //创建临时队列
            List<Integer> tmp = new ArrayList<>();
            //此时已知当前层数的节点数量，进行遍历即可得知本层的节点值
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(tmp);
        }
        return list;
    }
}
