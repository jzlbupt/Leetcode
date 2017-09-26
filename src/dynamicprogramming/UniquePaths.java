package dynamicprogramming;

/**
 * Created by ziljin on 26/09/2017.
 */

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach
 the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 Note: m and n will be at most 100.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        if(m == 0 || n == 0) return 0;
        if(m == 1 || n == 1) return 1;

        for(int i=0; i<m; i++) {
            board[i][0] = 1;
        }
        for(int i=0; i<n; i++) {
            board[0][i] = 1;
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                board[i][j] = board[i][j-1] + board[i-1][j];
            }
        }
        return board[m-1][n-1];
    }
}
