package backtracking;

/**
 * Created by ziljin on 13/09/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        if(nums == null || nums.length == 0) return rst;
        dfs(nums, rst, tmp, 0);
        return rst;

    }
    private void dfs(int[] nums, List<List<Integer>> rst, List<Integer> tmp, int startIndex) {
        rst.add(new ArrayList<>(tmp));

        for(int i=startIndex; i<nums.length ;i++) {
            tmp.add(nums[i]);
            dfs(nums, rst, tmp, i+1);
            tmp.remove(tmp.size() -1);
        }
    }
    // bit manipulation
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return rst;
        int len = nums.length;
        for(int i=0; i<(1<<len); i++) {
            List<Integer> tmp = new ArrayList<>();
            for(int j=0; j<len; j++) {
                if((i & (1<<j)) != 0) {
                    tmp.add(nums[j]);
                }
            }
            rst.add(new ArrayList<>(tmp));
        }
        return rst;
    }

    public static void main(String args[]) {
        int[] nums = {1,2,3};
        List<List<Integer>> rst = new Subsets().subsets2(nums);
        System.out.println();
    }
}
