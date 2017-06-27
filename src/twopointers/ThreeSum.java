package twopointers;

/**
 * Created by ziljin on 26/06/2017.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

/**
 * Remember to skip the same result
 * For the first time , I used the middle number as iterator num.
 * Try to use the First number as iterator number...
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return rst; //return empty list, not null
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j=i+1, k=nums.length-1;
            List<Integer> tmp = new ArrayList<>();
            while(j < k) {
                int sum = nums[j] + nums[k];
                if(sum == -nums[i]) {
                    tmp.clear();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    rst.add(new ArrayList<>(tmp));
                    while(j<k && nums[j+1] == nums[j]) j++; //ship the same number
                    j++;
                    while(k>j && nums[k-1] == nums[k]) k--;
                    k--;
                }else if(sum < -nums[i]) {
//                    while(j<k && nums[j+1] == nums[j]) j++; // no need to check  ...????
                    j++;
                }else{
//                    while(k>j && nums[k-1] == nums[k]) k--;
                    k--;
                }
            }
        }
        return rst;

    }

// bug solution =====================================================
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> rst = new ArrayList<List<Integer>>();
//        if(nums == null || nums.length <3) return rst;
//        Arrays.sort(nums);
//
//        List<Integer> tmp = new ArrayList<>();
//        for(int m=1; m<nums.length-1; m++) {
//            if(m>1 && nums[m] == nums[m-1]) continue;
//            int i=0, j=nums.length-1; // for the begin point and end point
//            int mid = -nums[m];
//            while(i<m && m<j){
//                int sum = nums[i] + nums[j];
//                if(sum == mid) {
//                    tmp.clear();
//                    tmp.add(nums[i]);
//                    tmp.add(nums[m]);
//                    tmp.add(nums[j]);
//                    rst.add(new ArrayList<>(tmp));
//                    i++;
//                    j--;
//                }else if( sum < mid) {
//                    i++;
//                }else {
//                    j--;
//                }
//            }
//        }
//        return rst;
//    }

    public static void main(String args[]){
        int nums[] = {-2,0,0,2,2};
        List<List<Integer>> rst = new ThreeSum().threeSum(nums);
        System.out.println(2);
    }
}
