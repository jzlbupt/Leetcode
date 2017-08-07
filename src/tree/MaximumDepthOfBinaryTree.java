package tree;

/**
 * Created by ziljin on 07/08/2017.
 */

/**
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest
 path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return maxHelper(root, 0);
    }

    public int maxHelper(TreeNode root, int max){
        if(root == null) return max;
        if(root.left == null && root.right == null){
            return max + 1;
        }else {
            return Math.max(maxHelper(root.left, max), maxHelper(root.right, max)) + 1;
        }
    }
}
