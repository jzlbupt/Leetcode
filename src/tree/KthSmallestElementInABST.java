package tree;

/**
 * Created by ziljin on 05/09/2017.
 */

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest
 frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        int c = count(root.left);
        if(k <= c) {
            return kthSmallest(root.left, k);
        }
        if(k > c + 1){
            return kthSmallest(root.right, k - c - 1);
        }
        return root.val;
    }
    private int count(TreeNode node) {
        if(node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }
}
