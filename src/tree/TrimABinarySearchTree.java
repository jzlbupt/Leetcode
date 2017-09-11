package tree;

/**
 * Created by ziljin on 08/09/2017.
 */

/**
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

 Example 1:
 Input:
   1
  / \
 0   2

 L = 1
 R = 2

 Output:
 1
  \
   2
 Example 2:
 Input:
    3
   / \
  0   4
   \
   2
  /
 1

 L = 1
 R = 3

 Output:
     3
    /
   2
  /
 1
 */
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(L > R) return null;
        TreeNode left = trimBST(root.left, L, Math.min(root.val, R));
        TreeNode right = trimBST(root.right, Math.max(root.val, L), R);
        if(root.val >= L && root.val <= R) {
            root.left = left;
            root.right = right;
            return root;
        }
        return left == null ? right : left;
    }

    public TreeNode trimBST2(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.val < L){
            return trimBST2(root.right, L, R);
        }
        if(root.val > R) {
            return trimBST2(root.left, L, R);
        }
        root.left = trimBST2(root.left, L, R);
        root.right = trimBST2(root.right, L, R);
        return root;
    }
}
