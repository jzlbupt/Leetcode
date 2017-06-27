package twopointers;

/**
 * Created by ziljin on 26/06/2017.
 */

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once
 * and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length<1) return 0;
        int j=0;
        for(int i=0;i<nums.length; i++){
            if(nums[j] == nums[i]) continue;
            nums[++j] = nums[i];
        }
        return ++j;
    }
    public static void main(String args[]) {
        int nums[] = {1,1,1,2,3,3,4};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
    }
}
