package tree;

/**
 * Created by ziljin on 04/09/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
  1
   \
   2
  /
 3
 return [1,2,3].

 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if(root == null) return rst;
        rst.add(root.val);
        rst.addAll(preorderTraversal(root.left));
        rst.addAll(preorderTraversal(root.right));
        return rst;
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        helper(root, rst);
        return rst;
    }
    private void helper(TreeNode root, List<Integer> rst) {
        if(root == null) return;
        rst.add(root.val);
        helper(root.left, rst);
        helper(root.right, rst);
    }
}
