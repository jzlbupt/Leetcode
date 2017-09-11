package array;

/**
 * Created by ziljin on 11/09/2017.
 */

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length;
        int mid = start;
        while(start + 1 < end) {
            mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        return start + 1;
    }
}
