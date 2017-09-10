package array;

/**
 * Created by JZL on 17/9/10.
 */

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].

 */
public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0) return res;

        int start = firstGreatNum(nums, target);
        if(start == nums.length || nums[start] != target)
            return new int[]{-1, -1};
        int end = firstGreatNum(nums, target + 1) - 1;
        return new int[]{start, end};

    }
    private int firstGreatNum(int[] nums, int target) {
        int start = 0, end = nums.length;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
