package tree;

/**
 * Created by ziljin on 28/08/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

  1         3     3      2      1
   \       /     /      / \      \
   3     2     1      1   3      2
  /     /       \                 \
 2     1         2                 3

 */
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return genTree(1, n);
    }

    private List<TreeNode> genTree(int start, int end) {
        List<TreeNode> rst = new ArrayList<>();
        if(start > end) {
            rst.add(null);
            return rst;
        }
        if(start == end) {
            rst.add(new TreeNode(start));
            return rst;
        }
        List<TreeNode> left, right;
        for(int i=start; i<=end; i++){
            left = genTree(start, i-1);
            right = genTree(i+1, end);

            for( TreeNode nl : left) {
                for(TreeNode nr : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = nl;
                    node.right = nr;
                    rst.add(node);
                }
            }
        }
        return rst;
    }
}
