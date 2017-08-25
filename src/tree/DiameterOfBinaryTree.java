package tree;

/**
 * Created by ziljin on 25/08/2017.
 */

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.

 Example:
 Given a binary tree
     1
    / \
   2   3
  / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return Math.max(Math.max(pathByRoot(root) , diameterOfBinaryTree(root.left)),
                diameterOfBinaryTree(root.right));
    }
    private int pathByRoot(TreeNode root){
        if(root == null) return 0;
        return maxDepth(root.left) + maxDepth(root.right);
    }
    private int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
    public static void main(String args[]) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode (3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(node));
    }
}
