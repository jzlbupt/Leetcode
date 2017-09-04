package tree;

/**
 * Created by ziljin on 04/09/2017.
 */

import java.util.ArrayList;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized
 * with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is
 the height of the tree.
 */
public class BSTIterator {

    private int pointer;
    private ArrayList<Integer> nodeVals = new ArrayList<Integer>();
    private int size;

    private void inOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        nodeVals.add(node.val);
        inOrder(node.left);
        inOrder(node.right);
    }

    public BSTIterator(TreeNode root) {
        inOrder(root);
        pointer = 0;
        size = nodeVals.size();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return pointer < size;

    }

    /** @return the next smallest number */
    public int next() {
        return nodeVals.get(pointer ++);
    }
}
