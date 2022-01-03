package com.itsnine.code.sword.middle.search;

import com.itsnine.code.sword.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 * 同一层的节点按照从左到右打印
 *
 * @author xu.sun
 * @create 2021-08-10-8:34 下午
 */
public class PrintTreeNode {

    /**
     * 层序遍历BFS
     * 使用队列的特性，先进先出
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * queue.add()-入队列
     * queue.poll()-出队列
     *
     * @param root
     * @return
     */
    public int[] resolve(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        //初始化队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);

        //队列不为空进行遍历
        while (!queue.isEmpty()) {
            //出队列，将值加入list
            TreeNode node = queue.poll();
            list.add(node.val);
            //当前节点的左节点若不为空，将左节点加入队列，右节点同理
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        //将ArrayList转换为int[]
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
