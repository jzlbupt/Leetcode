package backtracking;

/**
 * Created by ziljin on 13/09/2017.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        if(nums == null || nums.length == 0) return rst;
        Arrays.sort(nums);
        dfs(nums, rst, tmp, 0);
        return rst;
    }
    private void dfs(int[] nums, List<List<Integer>> rst, List<Integer> tmp, int pos) {
        rst.add(new ArrayList<>(tmp));

        for(int i=pos; i<nums.length; i++) {
            if(i>pos && nums[i] == nums[i-1]) continue;
            tmp.add(nums[i]);
            dfs(nums, rst, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
    public static void main(String args[]) {
        int[] nums = {1,2,2};
        List<List<Integer>> rst = new Subsets2().subsetsWithDup(nums);
        System.out.println();
    }
}
