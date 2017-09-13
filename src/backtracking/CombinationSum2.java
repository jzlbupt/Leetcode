package backtracking;

/**
 * Created by ziljin on 12/09/2017.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) return rst;
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<Integer>();
        helper(candidates, target, rst, tmp, 0);
        return rst;
    }
    private void helper( int[] candidates, int target, List<List<Integer>> rst, List<Integer> tmp,int pos) {
        if(target == 0) {
            rst.add(new ArrayList<>(tmp));
            return;
        }
        if(target < 0) return;
        for(int i=pos; i< candidates.length; i++) {
            if(i > pos && candidates[i] == candidates[i-1]) {
                continue;
            }
            tmp.add(candidates[i]);
            helper(candidates, target - candidates[i], rst, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
    public static void main(String args[]) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> rst = new CombinationSum2().combinationSum2(candidates, 8);
        System.out.println();
    }
}
