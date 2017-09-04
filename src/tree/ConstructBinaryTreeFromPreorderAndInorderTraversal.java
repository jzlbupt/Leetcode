package tree;

/**
 * Created by ziljin on 01/09/2017.
 */

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length -1);
    }
    private TreeNode build(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if(ps>pe) return null;
        if(ps == pe) return new TreeNode(pre[ps]);
        int rootVal = pre[ps];
        TreeNode node = new TreeNode(rootVal);
        int rootIndex = -1;
        for(int i=is; i<=ie; i++){
            if(in[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        node.left = build(pre, ps + 1,ps + rootIndex - is ,in, is, rootIndex -1);
        node.right = build(pre, ps + rootIndex - is + 1, pe , in, rootIndex + 1, ie);
        return node;
    }

}
