package twopointers;

/**
 * Created by ziljin on 05/07/2017.
 */

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of
 * the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int i=0, j=nums.length-1;
        while(i<nums.length && nums[i] == 0) i++;
        while(j>0 && nums[j] == 2) j--;
        int k = i;
        if(i>j) return;
        while(k<=j && k>=i) {
            if(nums[k] == 1){
                k++;
            }else if(nums[k] == 0){
                nums[k] = nums[i];
                nums[i] = 0;
                if(nums[k] == 0) k++;
                while(i<nums.length && nums[i] == 0)i++;
            }else {
                nums[k] = nums[j];
                nums[j] = 2;
                if(nums[k] == 2) k++;
                while(j>0 && nums[j] == 2)j--;
            }
        }
    }
    public static void main(String args[]){
        int nums[] = {2,2,0,0,2,0,2,1,0};
        new SortColors().sortColors(nums);
        System.out.println(0);
    }
}
