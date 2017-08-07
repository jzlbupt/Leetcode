package tree;

/**
 * Created by ziljin on 18/07/2017.
 */

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
 between two nodes v and w as the lowest node in T that has both v and w as descendants
 (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
   ___2__          ___8__
  /      \        /      \
 0      _4       7       9
      /  \
     3   5
 For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
 Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
 according to the LCA definition.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return root;
        int pVal = p.val, qVal = q.val;
        TreeNode node = root;
        while(node != null){
            int v = node.val;
            if(v>pVal && v>qVal){
                node = node.left;
            }else if(v<pVal && v<qVal){
                node = node.right;
            }else if((v>=pVal && v<=qVal) || (v<=pVal && v>=qVal)){
                return node;
            }
        }
        return node;
    }
}
