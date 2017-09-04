package tree;

/**
 * Created by ziljin on 01/09/2017.
 */

import twopointers.ValidPalindrome;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example 1:
   2
  / \
 1   3
 Binary tree [2,1,3], return true.
 Example 2:
   1
  / \
 2   3
 Binary tree [1,2,3], return false.

 */

// Testcase considered the max value of Integer, so changed the parameter to Long...
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValid(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isValid(left, min, root.val) && isValid(right, root.val, max);
    }
    public static void main(String args[]) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }
}
