package dynamicprogramming;

/**
 * Created by ziljin on 26/09/2017.
 */

/**
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.
 */
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        for(int i=0; i<m; i++) {
            if(obstacleGrid[i][0] == 1) {
                for(int k=i; k<m; k++){
                    obstacleGrid[k][0] = 0;
                }
                break;
            }
            obstacleGrid[i][0] = 1;
        }
        for(int i=1; i<n; i++) {
            if(obstacleGrid[0][i] == 1) {
                for(int k=i; k<n; k++){
                    obstacleGrid[0][k] = 0;
                }
                break;
            }
            obstacleGrid[0][i] = 1;
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                }else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] +obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }

    public static void main(String args[]) {
        int[][] nums = {{1,0}};
        System.out.println(new UniquePaths2().uniquePathsWithObstacles(nums));

    }
}
