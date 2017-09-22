package backtracking;

/**
 * Created by ziljin on 19/09/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


 Example 1:

 Input: k = 3, n = 7
 Output:
 [[1,2,4]]

 Example 2:
 Input: k = 3, n = 9
 Output:
 [[1,2,6], [1,3,5], [2,3,4]]

 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(k <= 0 || n <=0) return rst;
        dfs(k, n, rst, new ArrayList<>(), 1);
        return rst;
    }

    private void dfs(int k, int sum, List<List<Integer>> rst, List<Integer> tmp, int pos) {
        if(sum == 0 && tmp.size() == k) {
            rst.add(new ArrayList<Integer>(tmp));
            return;
        }
        if(sum < 0 || tmp.size() > k) {
            return;
        }
        for(int i=pos; i<=9; i++) {
            tmp.add(i);
            dfs(k, sum - i, rst, tmp, i + 1);
            tmp.remove(tmp.size() -1);
        }
    }
    public static void main(String args[]) {
        int k = 3, n = 9;
        List<List<Integer>> rst = new CombinationSum3().combinationSum3(k,n);
        System.out.println();
    }
}
