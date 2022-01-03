package com.itsnine.code.sword.middle.search;

/**
 * 二维数组的查找
 *
 * @author xu.sun
 * @create 2021-08-09-10:50 下午
 */
public class FindNumIn2DArray {
    /**
     * 【1 ， 4， 7，11，15】
     * 【2 ， 5， 8，12，19】
     * 【3 ， 6， 9，16，22】
     * 【10，13，14，17，24】
     * n*m二维数组 从左至右递增，从上至下递增
     * <p>
     * 设置二维数组的左下角为索引起始点（i，j）（行坐标，列坐标）
     * 当索引位置的数字小于target 索引上移 i--
     * 当索引位置的数字大于target 索引右移 j++
     * 相等时返回true
     * 若索引越界则返回false （i<0 || j>列长度 matrix[0].length）
     * 时间复杂度O(m+n)
     * 空间复杂度O(1)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean resolve(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
