package tree;

/**
 * Created by ziljin on 05/09/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
 two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a
 node to be a descendant of itself).”

           _______3______
          /              \
      ___5__          ___1__
     /      \        /      \
    6      _2       0       8
         /  \
        7   4
 For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of
 nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        //to looking for p and q in left and right subtree,
        //if they are in two subtree separately , then root is the lowest common ancestor
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }
    public static void main(String args[]) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node.left = node2;
        TreeNode rst = new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(node, node, node2);
    }
}
