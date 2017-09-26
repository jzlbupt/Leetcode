package dynamicprogramming;

/**
 * Created by ziljin on 26/09/2017.
 */

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom
 * right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) grid[i][j] = grid[i][j-1] + grid[i][j];
                if(j == 0) grid[i][j] = grid[i-1][j] + grid[i][j];
                if(i != 0 && j != 0) grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[m-1][n-1];
    }
}
