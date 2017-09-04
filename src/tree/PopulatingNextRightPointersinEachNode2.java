package tree;

/**
 * Created by ziljin on 04/09/2017.
 */

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
      1
    /  \
   2    3
  / \    \
 4   5    7
 After calling your function, the tree should look like:
       1 -> NULL
     /  \
    2 -> 3 -> NULL
  /  \    \
 4-> 5 -> 7 -> NULL

 */
public class PopulatingNextRightPointersinEachNode2 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null;
        TreeLinkNode prev = null;
        TreeLinkNode curr = root;
        while(curr != null) {
            while(curr != null) {
                if(curr.left != null) {
                    if(prev != null) {
                        prev.next = curr.left;
                    }else {
                        head = curr.left;
                    }
                    prev = curr.left;
                }
                if(curr.right != null) {
                    if(prev != null) {
                        prev.next = curr.right;
                    }else {
                        head = curr.right;
                    }
                    prev = curr.right;
                }
                curr = curr.next;
            }
            curr = head;
            prev = null;
            head = null;
        }
    }
}
