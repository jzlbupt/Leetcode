package tree;

/**
 * Created by ziljin on 24/08/2017.
 */

/**
 * Find the sum of all left leaves in a given binary tree.

 Example:

     3
    / \
   9  20
  /  \
 15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int rst = 0;
        if(root != null) {
            if(root.left != null){
                rst += (isLeaf(root.left) == true ? root.left.val : sumOfLeftLeaves(root.left));
            }
            if(root.right != null){
                rst += (isLeaf(root.right) == true ? 0: sumOfLeftLeaves(root.right));
            }
        }
        return rst;
    }
    private boolean isLeaf(TreeNode node) {
        if(node.left == null && node.right == null) return true;
        return false;
    }
}
