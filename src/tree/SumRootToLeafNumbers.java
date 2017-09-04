package tree;

/**
 * Created by ziljin on 04/09/2017.
 */

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

   1
  / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    private int sum(TreeNode root, int prevSum) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return prevSum*10 + root.val;
        }
        return sum(root.left, prevSum*10 + root.val)
                + sum(root.right, prevSum*10 + root.val);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }
}
