package twopointers;

/**
 * Created by ziljin on 05/07/2017.
 */

/**
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums
 being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */

/**
 * See more details on: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/#/description
 */
public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <=2 ) return nums == null ? 0 : nums.length;

        int i=0;
        for(int n : nums) {
            if(i<2 || n>nums[i-2]) {
                nums[i++] = n;
            }
        }
        return i;

    }
    public static void main(String args[]){
        int nums[] = {1,1,2,2,2,3,3,4};
        System.out.println(new RemoveDuplicatesFromSortedArray2().removeDuplicates(nums));
    }
}
