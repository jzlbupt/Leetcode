package twopointers;

/**
 * Created by ziljin on 27/06/2017.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        int rst = Integer.MAX_VALUE;
        if(nums == null || nums.length <= 2) return rst;
        rst = nums[0]+ nums[1] + nums[2];  // 1. initialize
        Arrays.sort(nums);  // 2. sort
        for(int i=0; i<nums.length-2; i++) {
            int j=i+1, k=nums.length-1;  // 3. initialize j as i+1 in loop
            if(i>0 && nums[i] == nums[i-1]) continue;
            while(j<k){  // 4. while loop to check all the available array
                int sum = nums[j] + nums[k] + nums[i];
                rst = Math.abs(target - sum) == Math.min(Math.abs(target - sum), Math.abs(target - rst))
                        ? sum : rst;
                if(sum == target){
                    return target;
                }
                if(sum < target){
                    while(j<k && nums[j] == nums[j+1]) j++;
                    j++;
                }else {
                    while(j<k && nums[k] == nums[k-1]) k--;
                    k--;
                }
            }

        }
        return rst;
    }
    public static void main(String args[]){
        int nums[] = {-3,-2,-4,-5,3};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, -1));
    }
}
