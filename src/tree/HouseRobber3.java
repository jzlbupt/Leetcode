package tree;

/**
 * Created by ziljin on 06/09/2017.
 */

/**
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into
 * on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:
    3*
   / \
  2   3
   \   \
    3*  1*
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 Example 2:
     3
    / \
   4*  5*
  / \   \
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobber3 {
    public int rob(TreeNode root) {
        int[] rst = robSub(root);
        return Math.max(rst[0], rst[1]);

    }
    private int[] robSub(TreeNode root) {
        if(root == null) return new int[2];
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] rst = new int[2];

        // if not rob the root house
        rst[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // if rob the root house, the thief cannot rob the left and right child of the root house
        rst[1] = root.val + left[0] + right[0];
        return rst;
    }
}
