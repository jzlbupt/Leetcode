package twopointers;

/**
 * Created by ziljin on 27/06/2017.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */

/**
 * Tip: remember what the "target" is... add the right number into tmp list
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length-3; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            threeSum(nums, i+1, nums[i], target-nums[i], rst);
        }
        return rst;
    }
    public void threeSum(int[] nums, int start, int numsi, int target, List<List<Integer>> rst){
        for(int i=start; i<nums.length-2; i++) {
            if(i>start && nums[i] == nums[i-1]) continue;
            int j= i+1, k=nums.length-1;
            int newTar = target - nums[i];
            while(j<k){
                int sum = nums[j] + nums[k];
                if(sum == newTar) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(numsi);
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    rst.add(tmp);
                    while(j<k && nums[j] == nums[j+1]) j++;
                    j++;
                    while(j<k && nums[k] == nums[k-1]) k--;
                    k--;
                }else if(sum < newTar) {
                    j++;
                }else {
                    k--;
                }
            }

        }
    }
    public static void main(String args[]) {
        int nums[] = {-3,-2,-1,0,0,1,2,3};
        List<List<Integer>> rst = new FourSum().fourSum(nums, 0);
        System.out.println(0);
    }
}
