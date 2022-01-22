package com.itsnine.code.sword.middle.dp;

/**
 * 二维数组中的最短路径
 *
 * @author xu.sun
 * @create 2022-01-03-11:55 上午
 */
public class MinPathSum {
    private static int minSum = Integer.MAX_VALUE;
    private static int[][] dirs = {{0, 1}, {1, 0}};

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        minPathSum1(grid);
        System.out.println(minSum);
    }

    /**
     * 回溯算法
     *
     * @param grid
     * @return
     */
    public static int minPathSum1(int[][] grid) {
        dfs(grid, 0, 0, grid[0][0]);
        return minSum;
    }

    private static void dfs(int[][] grid, int row, int col, int sum) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            minSum = Math.min(minSum, sum);
            return;
        }
        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length) {
                continue;
            }
            sum += grid[nextRow][nextCol];
            dfs(grid, nextRow, nextCol, sum);
            sum -= grid[nextRow][nextCol];
        }
    }


    /**
     * 动态规划，空间压缩
     * 时间复杂度O(n*n)
     * 空间复杂度O(n)
     * dp[0][0] = grid[0][0]
     * dp[0][j] = grid[0][j] + dp[0][j-1]
     * dp[i][0] = grid[i][0] + dp[i-1][0]
     * dp[i][j] = grid[i][j] + Min(dp[i-1][j],dp[i][j-1])
     * 其实当前节点的最小值仅关注他左边节点时最小值以及他上边节点的最小值，无需存储其他的最小值
     * 第一行只关注他左边的最小值，第一列只关注他上边的最小值
     *
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        //记录当前行中的最短路径
        int[] dp = new int[colLen];

        //初始化第一个最小值节点
        dp[0] = grid[0][0];

        //逐行遍历，确定上层最小值，第二行计算时会逐一覆盖掉之前行的最小值
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                //第一行仅关注他左边的最小值
                if (i == 0 && j != 0) {
                    dp[j] = grid[i][j] + dp[j - 1];
                }
                //第一列仅关注他上边（最小值队列同列）的最小值
                if (j == 0 && i != 0) {
                    dp[j] = grid[i][j] + dp[j];
                }
                //第i行j列关注他左边的以及他上边（最小值队列同列）的最小值
                if (j != 0 && i != 0) {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }

        //最小值队列中的最后一个值即为最短路径
        return dp[colLen - 1];
    }
}
