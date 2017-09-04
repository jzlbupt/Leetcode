package tree;

/**
 * Created by ziljin on 01/09/2017.
 */

/**
 * Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

     1
    / \
   2   5
  / \   \
 3   4   6

 The flattened tree should look like:
 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
 */

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        TreeNode tmp = left;
        while(left != null && left.right != null){
            left = left.right;
        }
        if(left != null) {
            left.left = null;
            left.right = right;
            root.left = null;
            root.right = tmp;
        }
    }
    // easy way ...
    private TreeNode prev = null;
    public void flatten1(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);;
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        new FlattenBinaryTreeToLinkedList().flatten(root);
        System.out.println(0);
    }
}
