package backtracking;

/**
 * Created by ziljin on 12/09/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        if(nums == null || nums.length == 0) return rst;
        boolean[] visited = new boolean[nums.length];
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
            tmp.add(nums[i]);
            visited[i] = true;
            helper(nums, rst, tmp, visited);
            visited[i] = false;
            tmp.remove(tmp.size() -1);
        }
    }
    public static void main(String args[]) {
        int[] nums = {1,2,3};
        List<List<Integer>> rst = new Permutations().permute(nums);
        System.out.println();
    }
}
