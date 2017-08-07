package tree;

/**
 * Created by ziljin on 07/08/2017.
 */

/**
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which
 the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        return isBalanced(root.left)&&isBalanced(root.right)
                &&(Math.abs(depth(root.left)-depth(root.right))<=1) ;
    }
    private int depth(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }
}
