package tree;

/**
 * Created by ziljin on 04/09/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of
 * the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
     1            <---
   /   \
  2     3         <---
   \     \
    5     4       <---
 You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        rightView(root, rst, 0);
        return rst;
    }

    private void rightView(TreeNode root, List<Integer> rst, int currdepth) {
        if(root == null) return;
        if(rst.size() == currdepth) {
            rst.add(root.val);
        }
        rightView(root.right, rst, currdepth + 1);
        rightView(root.left, rst, currdepth + 1);
    }
}
