package dynamicprogramming;

/**
 * Created by ziljin on 25/09/2017.
 */

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact
 * the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max1 = nums[0];
        if(nums.length == 1) return max1;
        int max2 = Math.max(nums[0],nums[1]);
        for(int i=2; i<nums.length; i++) {
            int tmp = max2;
            max2 = Math.max(max2, max1 + nums[i]);
            max1 = tmp;
        }
        return Math.max(max1, max2);
    }
}
