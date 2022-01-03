package com.itsnine.code.sword.simple.tree;

import com.itsnine.code.sword.base.TreeNode;

import java.util.Objects;
import java.util.Stack;

/**
 * 二叉树的镜像
 * 树的左节点与有节点翻转
 *
 * @author xu.sun
 * @create 2021-08-19-10:31 下午
 */
public class MirrorTree {

    /**
     * 递归遍历
     * tmp暂存当前节点的左节点
     * 开启右子节点的递归，作为当前节点的左子节点
     * 开启左子节点的递归，作为当前节点的右子节点
     * 当下一个节点为空的时候，遍历终止
     * 时间复杂度O(n) 遍历所有节点
     * 空间复杂度O(n) 二叉树最差情况为链表 需要O(n)大小的栈空间
     *
     * @param root
     * @return
     */
    public TreeNode resolve(TreeNode root) {
        if (Objects.isNull(root)){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = resolve(root.right);
        root.right = resolve(tmp);
        return root;
    }

    /**
     * 辅助栈
     * 先进后出，左节点后出
     * 同层级的节点先入栈
     * 节点出栈后，将当前节点的左右节点入栈，
     * 再交换两个节点
     * 当栈为空时，遍历完成
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param root
     * @return
     */
    public TreeNode supStack(TreeNode root) {
        if (Objects.isNull(root)){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (Objects.nonNull(node.left)){
                stack.add(node.left);
            }
            if (Objects.nonNull(node.right)){
                stack.add(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
