package tree;

/**
 * Created by ziljin on 07/08/2017.
 */

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int start, int end){
        if(nums == null || nums.length == 0 || start>end) return null;
        int r = start + (end-start) /2;
        TreeNode root = new TreeNode(nums[r]);
        root.left = helper(nums, start, r-1);
        root.right = helper(nums, r+1, end);
        return root;
    }
}
