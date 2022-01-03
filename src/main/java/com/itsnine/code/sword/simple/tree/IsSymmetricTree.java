package com.itsnine.code.sword.simple.tree;

import com.itsnine.code.sword.base.TreeNode;

import java.util.Objects;

/**
 * 对称树
 * 对称树条件：根的左节点与右节点相同，左节点的子左节点与右节点的子右节点相同，左节点的子右节点与右节点的子左节点相同
 * 递归遍历每个层级
 * 终止条件：
 * 1.左节点与右节点为空 返回true
 * 2.左右节点有一个为空或左右节点值不相等 返回false
 * 遍历左节点的子左节点与右节点的子右节点，左节点的子右节点与右节点的子左节点相同，均相等返回true
 * 时间复杂度O(n) n为树的节点数量，每次递归可判断一对节点是否对称，最多递归n/2次
 * 空间复杂度O(n) 当树退化为链表时，最大递归深度为会达到n
 *
 * @author xu.sun
 * @create 2021-08-25-11:23 下午
 */
public class IsSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return Objects.isNull(root) ? true : recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        if (Objects.isNull(left) && Objects.isNull(right)){
            return true;
        }
        if (Objects.isNull(left) || Objects.isNull(right) || !Objects.equals(left.val, right.val)){
            return false;
        }
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
