package array;

/**
 * Created by ziljin on 11/09/2017.
 */

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order
 (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are
 in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int index = nums.length -1;
        while(index >= 1 && nums[index] <=nums[index-1]) index --;
        if(index == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        index --;
        int biggerThanIndex = nums.length - 1;
        while(index < biggerThanIndex && nums[biggerThanIndex] <= nums[index]) biggerThanIndex --;
        swap(nums, index, biggerThanIndex);
        reverse(nums, index + 1, nums.length -1);
    }
    private void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }
    private void reverse(int[] nums, int p1, int p2) {
        while(p1 < p2) {
            swap(nums, p1, p2);
            p1++;
            p2--;
        }
    }
    public static void main(String args[]) {
        int[] nums = {1,5,1};
        new NextPermutation().nextPermutation(nums);
        System.out.println();
    }
}
