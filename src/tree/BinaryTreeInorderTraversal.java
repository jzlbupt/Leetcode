package tree;

/**
 * Created by ziljin on 28/08/2017.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree [1,null,2,3],
 1
  \
   2
  /
 3
 return [1,3,2].
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> rst = new ArrayList<Integer>();
        if(root == null) return rst;
        rst.addAll(inorderTraversal(root.left));
        rst.add(root.val);
        rst.addAll(inorderTraversal(root.right));
        return rst;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pollLast();
            rst.add(curr.val);
            curr = curr.right;
        }
        return rst;
    }
}
