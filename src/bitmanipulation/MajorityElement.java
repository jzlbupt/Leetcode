package bitmanipulation;

/**
 * Created by ziljin on 02/11/2017.
 */

/**
 * Given an array of size n, find the majority element. The majority element is the element
 * that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 1, num = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == num){
                count ++;
            }else{
                if(count != 0) count --;
                else{
                    count = 1;
                    num = nums[i];
                }
            }
        }
        return num;
    }
}
