package array;

/**
 * Created by JZL on 17/9/10.
 */

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.


 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length -1 ;
        int mid;
        while(start + 1 < end) {
            mid = start + (end - start)/2;
            if(target == nums[mid]) {
                return mid;
            }

            if(nums[start] < nums[mid]) {
                if(target <= nums[mid] && target >= nums[start]) {
                    end = mid;
                }else {
                    start = mid;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
}
