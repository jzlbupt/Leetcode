package tree;

/**
 * Created by ziljin on 01/09/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals
 * the given sum.

 For example:
 Given the below binary tree and sum = 22,
       5
      / \
     4   8
    /   / \
   11  13  4
  /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        helper(root, sum, rst, tmp);
        return rst;
    }
    private void helper(TreeNode root, int sum, List<List<Integer>> rst, List<Integer> tmp) {
        if(root == null) return;
        if(sum == root.val && root.left == null && root.right == null){
            tmp.add(root.val);
            rst.add(new ArrayList<Integer>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }
        tmp.add(root.val);
        helper(root.left, sum - root.val, rst, tmp);
        helper(root.right, sum - root.val, rst, tmp);
        tmp.remove(tmp.size() - 1);
    }
}
