package tree;

/**
 * Created by ziljin on 24/08/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

    1
  /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<>();
        if(root != null) helper(root, "", rst);
        return rst;
    }
    private void helper(TreeNode root, String path, List<String> rst){
        if(root.left == null && root.right == null) {
            rst.add(path + root.val);
        }
        if(root.left != null) helper(root.left, path + root.val + "->", rst);
        if(root.right != null) helper(root.right, path + root.val + "->", rst);
    }
}
