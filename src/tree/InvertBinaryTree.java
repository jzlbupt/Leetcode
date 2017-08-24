package tree;

/**
 * Created by ziljin on 24/08/2017.
 */

/**
 * Invert a binary tree.

      4
    /   \
   2     7
  / \   / \
 1   3 6   9

 to
      4
    /   \
   7     2
  / \   / \
 9   6 3   1
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        TreeNode ll = null, rr = null;
        if(root.left != null){
            ll = invertTree(root.left);
        }
        if(root.right != null){
            rr = invertTree(root.right);
        }
        root.left = rr;
        root.right = ll;
        return root;
    }
}
