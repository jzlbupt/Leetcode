package tree;

/**
 * Created by ziljin on 01/09/2017.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node,
 the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
 and every parent has two children).
 For example,
 Given the following perfect binary tree,
      1
    /  \
   2    3
  / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
      1 -> NULL
    /  \
   2 -> 3 -> NULL
  / \  / \
 4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersInEachNode {
    //this solution also works for Pupulating...2 problem
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode prev = queue.poll();
            if(prev.left != null) queue.offer(prev.left);
            if(prev.right != null) queue.offer(prev.right);
            TreeLinkNode next = null;
            for(int i=1; i<size; i++) {
                next = queue.poll();
                if(next.left != null) queue.offer(next.left);
                if(next.right != null) queue.offer(next.right);
                prev.next = next;
                prev = next;
            }
            if(next != null) next.next = null;
        }
        return;
    }

    // a better way to solve this issue...
    public void connect1(TreeLinkNode root) {
        if (root == null) return;
        if(root.left != null) {
            root.left.next = root.right;
            if(root.next!= null) {
                root.right.next = root.next.left;
            }
        }
        connect1(root.left);
        connect1(root.right);
    }

    public static void main(String[] args) {
        TreeLinkNode node = new TreeLinkNode(0);
        node.left = new TreeLinkNode(1);
        node.right = new TreeLinkNode(2);
        node.left.left = new TreeLinkNode(3);
        node.left.right = new TreeLinkNode(4);
        node.right.right = new TreeLinkNode(5);
        new PopulatingNextRightPointersInEachNode().connect(node);
        System.out.println(0);
    }
}
