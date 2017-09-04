package tree;

/**
 * Created by ziljin on 04/09/2017.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
  1
   \
   2
  /
 3
 return [3,2,1].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> rst = new LinkedList<Integer>();
        if(root == null) return rst;
        Stack<TreeNode> toVisit = new Stack<TreeNode>();
        toVisit.push(root);
        while(!toVisit.isEmpty()) {
            TreeNode node = toVisit.pop();
            rst.addFirst(node.val);
            if(node.left != null) toVisit.push(node.left);
            if(node.right != null) toVisit.push(node.right);
        }
        return rst;
    }
}
