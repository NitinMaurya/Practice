package practice.DSA.leetcode;

/*
Recursive Solution:
    Time Complexity = O(mn)
    Space Complexity = O(mn)

Iterative Solution:
    Time Complexity = O(mn)
    Space Complexity = O(1)
*/

public class MinPathSum {
    int minPathSumRecursive(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        return traverse(grid, 0, 0, dp);
    }

    int minPathSumIterative(int[][] grid){
        return traverse(grid);
    }

    private int traverse(int[][] grid, int i, int j, int[][] dp) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return Integer.MAX_VALUE;
        }
        else if (i == grid.length -1 && j == grid[0].length -1){
            return grid[i][j];
        }
        else if (dp[i][j] != 0){
            return dp[i][j];
        }
        else {
            return dp[i][j] = grid[i][j] + Math.min(traverse(grid, i+1, j, dp), traverse(grid, i, j+1, dp));
        }
    }

    private int traverse(int[][] grid){
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] += grid[0][j-1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        MinPathSum p = new MinPathSum();
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(p.minPathSumRecursive(grid));
        System.out.println(p.minPathSumIterative(grid));
    }
}
