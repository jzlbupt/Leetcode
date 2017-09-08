package tree;

/**
 * Created by ziljin on 07/09/2017.
 */

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 Recover the tree without changing its structure.

 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 */
public class RecoverBinarySearchTree {

    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    public void recoverTree(TreeNode root) {
        findTwoNodeWithInOrder(root);
        swapTwoNodeValues(firstNode, secondNode);
    }

    private void findTwoNodeWithInOrder(TreeNode root) {
        if(root == null) return;
        findTwoNodeWithInOrder(root.left);
        if(firstNode == null && preNode.val > root.val) {
            firstNode = preNode;
        }
        if(firstNode != null && preNode.val > root.val) {
            secondNode = root;
        }
        preNode = root;
        findTwoNodeWithInOrder(root.right);
    }

    private void swapTwoNodeValues(TreeNode n1, TreeNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        new RecoverBinarySearchTree().recoverTree(root);
    }
}
