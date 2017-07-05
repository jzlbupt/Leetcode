package twopointers;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ziljin on 05/07/2017.
 */

/**
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

 Note:
 Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

 Example:

 Given the following 3x6 height map:
 [
 [1,4,3,1,3,2],
 [3,2,1,3,2,4],
 [2,3,3,2,3,1]
 ]

 Return 4.
 */

/**
 * See more details on : https://leetcode.com/problems/trapping-rain-water-ii/#/description
 */
public class TrappingRainWater2 {
    public class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        int rst = 0;

        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.height - o2.height;
            }
        });

        for(int i=0; i<m; i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n-1, heightMap[i][n-1]));
        }
        for(int i=0; i<n; i++){
            visited[0][i] = true;
            visited[m-1][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            queue.offer(new Cell(m-1, i, heightMap[m-1][i]));
        }
        while(!queue.isEmpty()){
            int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
            Cell c = queue.poll();
            for(int i=0; i<dir.length; i++){
                int row = c.row + dir[i][0];
                int col = c.col + dir[i][1];
                if(row >= 0 && row < m && col >=0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    rst += Math.max(0, c.height - heightMap[row][col]);
                    queue.offer(new Cell(row, col, Math.max(c.height, heightMap[row][col])));
                }
            }
        }

        return rst;
    }
    public static void main(String args[]) {
        int[][] heightMap = {{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}};
        System.out.println(new TrappingRainWater2().trapRainWater(heightMap));
    }
}
