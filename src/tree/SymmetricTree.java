package tree;

/**
 * Created by ziljin on 09/08/2017.
 */

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

     1
    / \
   2   2
  / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
   1
  / \
 2   2
  \   \
   3   3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        TreeNode left = root.left, right = root.right;
        if(left == null && right == null) return true;
        if(left != null && right != null && left.val == right.val){
            return helper(left, right);
        }
        return false;
    }

    /**
     * check whether node1 is a mirror of node2
     * @param node1
     * @param node2
     * @return
     */
    private boolean helper(TreeNode node1, TreeNode node2) {
        if(node1 != null && node2 != null && node1.val == node2.val){
            return helper(node1.left, node2.right) && helper(node1.right, node2.left);
        }
        return false;
    }
}
