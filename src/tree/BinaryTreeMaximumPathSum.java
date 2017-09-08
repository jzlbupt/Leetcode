package tree;

/**
 * Created by ziljin on 07/09/2017.
 */

/**
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to
 any node in the tree along the parent-child connections. The path must contain at least
 one node and does not need to go through the root.

 For example:
 Given the below binary tree,

   1
  / \
 2   3
 Return 6.

 */
public class BinaryTreeMaximumPathSum {

    private int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return maxValue;
        maxPathDown(root);
        return maxValue;
    }

    /**
     * Get a max path sum value from node
     * @param node  The begin node of path...
     * @return max value of the path
     */
    private int maxPathDown(TreeNode node) {
        if(node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left+right+node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String args[]) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(node));
    }
}
