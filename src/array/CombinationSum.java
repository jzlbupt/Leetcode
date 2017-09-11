package array;

/**
 * Created by ziljin on 11/09/2017.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) return rst;
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, rst, tmp);
        return rst;
    }
    private void helper(int[] candidates, int target, List<List<Integer>> rst, List<Integer> tmp) {
        if(target == 0) {
            rst.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i=0; i<candidates.length; i++) {
            if()
            tmp.add(candidates[i]);
            target = target - candidates[i];
            helper(candidates, target, rst, tmp);
            tmp.remove(tmp.size() -1);
        }
    }
    public static void main(String args[]) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> rst = new CombinationSum().combinationSum(candidates, target);
        System.out.println();
    }
}
