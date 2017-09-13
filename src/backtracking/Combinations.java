package backtracking;

/**
 * Created by ziljin on 12/09/2017.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(n <= 0) return rst;
        List<Integer> tmp = new ArrayList<Integer>();
        boolean[] visited = new boolean[n];
        helper(n, visited, rst, tmp, k, 1);
        return rst;
    }
    private void helper(int n, boolean[] visited, List<List<Integer>> rst, List<Integer> tmp, int k, int pos) {
        if(tmp.size() == k) {
            rst.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i=pos; i<= n; i++) {
            if(visited[i-1] == true) {
                continue;
            }
            tmp.add(i);
            visited[i-1] = true;
            helper(n, visited, rst, tmp, k, i+1);
            visited[i-1] = false;
            tmp.remove(tmp.size() -1);
        }
    }
    public static void main(String args[]) {
        int n = 4, k=2;
        List<List<Integer>> rst = new Combinations().combine(n,k);
        System.out.println();
    }
}
