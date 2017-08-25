package tree;

/**
 * Created by ziljin on 25/08/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

 Example 1:
 Input:
     5
    / \
   3   6
  / \   \
 2   4   7

 Target = 9

 Output: True
 Example 2:
 Input:
     5
    / \
   3   6
  / \   \
 2   4   7

 Target = 28

 Output: False
 */
public class TwoSum4BST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int p1 = 0, p2 = nums.size()-1;
        while(p1 < p2){
            if(nums.get(p1) + nums.get(p2) == k) return true;
            else if(nums.get(p1) + nums.get(p2) < k) p1 ++;
            else p2 --;
        }
        return false;
    }
    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
