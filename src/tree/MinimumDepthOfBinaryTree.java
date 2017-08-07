package tree;

/**
 * Created by ziljin on 18/07/2017.
 */

/**
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down
 to the nearest leaf node.

 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getMin(root);
    }
    public int getMin(TreeNode node){
        if(node == null){
            return Integer.MAX_VALUE;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        return Math.min(getMin(node.left), getMin(node.right)) + 1;
    }

}
