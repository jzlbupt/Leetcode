package backtracking;

/**
 * Created by ziljin on 12/09/2017.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        if(nums == null || nums.length == 0) return rst;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, rst, tmp, visited);
        return rst;
    }
    private void helper(int[] nums, List<List<Integer>> rst, List<Integer> tmp, boolean[] visited) {
        if(tmp.size() == nums.length) {
            rst.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(visited[i] == true){
                continue;
            }
            if(i>0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            tmp.add(nums[i]);
            visited[i] = true;
            helper(nums, rst, tmp, visited);
            visited[i] = false;
            tmp.remove(tmp.size() -1);
        }
    }
    public static void main(String args[]) {
        int[] nums = {1,1,3};
        List<List<Integer>> rst = new Permutations2().permuteUnique(nums);
        System.out.println();
    }

}
