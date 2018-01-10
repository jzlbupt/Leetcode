package tree;

/**
 * Created by ziljin on 04/09/2017.
 */

import java.util.ArrayList;
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






    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> rst = new LinkedList<>();
        if(root == null) return rst;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            rst.addFirst(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return rst;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> rst = new LinkedList<>();
        if(root == null) return rst;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(curr);
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                curr = curr.left;
                stack.push(curr);
            }
            TreeNode node = stack.pop();
            rst.add(node.val);
            curr = node.right;
        }
        return rst;
    }


















}
