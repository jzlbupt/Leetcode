package tree;

/**
 * Created by ziljin on 01/09/2017.
 */

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length -1, postorder, 0, postorder.length -1);
    }
    private TreeNode build(int[] in, int is, int ie, int[] post, int ps, int pe) {
        if(ps > pe) return null;
        if(ps == pe  && ps >= 0) return new TreeNode(post[ps]);
        TreeNode root = new TreeNode(post[pe]);
        int rootIndex = -1;
        for(int i=is; i<=ie; i++) {
            if(in[i] == post[pe]){
                rootIndex = i;
                break;
            }
        }
        // really really careful about these index...
        root.left = build(in, is, rootIndex-1, post, ps, ps + rootIndex-is-1);
        root.right = build(in, rootIndex + 1, ie, post, ps + rootIndex, pe-1);
        return root;
    }
    public static void main(String[] args) {
        int[] in = {1,3,2};
        int[] post = {3,2, 1};
        TreeNode node = new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(in, post);
    }
}
