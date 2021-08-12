package com.itsnine.code.sword.middle.search;

import com.itsnine.code.sword.base.TreeNode;

/**
 * 树的子结构
 * 树A中有出现和B相同的结构和节点值
 *
 * @author xu.sun
 * @create 2021-08-12-9:56 下午
 */
public class IsSubTree {

    /**
     * 拆解递归
     * isEq为核心判断方法，递归主方法为拆解下推 ｜｜断位或目的是isEq方法已发现A树中的子树B，无需再进行拆解遍历
     * isEq核心：
     * 1.B树为空了，证明B树已匹配完成，超越叶子节点 返回true
     * 2.当A树为空了，B树还不为空 或 A树的值与B树的值不一致 返回false
     * 3.递归判断B的子节点与A的子节点完全一致
     * <p>
     * 主方法递归：
     * 1.当树A或树B为空直接返回false
     * 2.判断当前节点A与节点B结构与值是否一致
     * 3.若第2步不匹配，则下推到A树当前节点的左节点与B树进行匹配
     * 4.若第3步不匹配，则下推到A树当前节点的右节点与B树进行匹配
     * <p>
     * M，N为树A与树B的节点数
     * 遍历树A占用O(M)
     * 每次计算树A当前节点与树B是否匹配占用O(N)
     * 时间复杂度为O(MN)
     * 空间复杂度为O(M):当树A或树B退化为链表时，递归调用深度最大，最大为O(M)
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //当当前节点与树B不一致，向下推一级，先左节点再有节点。当某一节点完全匹配时，快速返回，下层不需要再进行匹配
        return (A != null && B != null) && (isEq(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean isEq(TreeNode a, TreeNode b) {
        //树B为空，已匹配完成（超越叶子节点）
        if (b == null) return true;
        //树A为空 或者 树A与树B的值不相等
        if (a == null || a.val != b.val) return false;
        //递归判断树A与树B的左节点、右节点是否一致
        return (isEq(a.left, b.left) && isEq(a.right, b.right));
    }


}
