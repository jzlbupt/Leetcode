package bitmanipulation;

/**
 * Created by ziljin on 01/11/2017.
 */

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int rst = 0;
        for(int i=0; i<len; i++) {
            rst ^= nums[i];
        }
        return rst;
    }

    public  static void main(String args[]) {
        int[] nums = {1,2,4,3,2,1,4};
        System.out.println(new SingleNumber().singleNumber(nums));
    }
}
