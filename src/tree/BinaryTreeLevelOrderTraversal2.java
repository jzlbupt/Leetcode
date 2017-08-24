package tree;

/**
 * Created by ziljin on 16/08/2017.
 */

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
     3
    / \
   9  20
  /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(root == null) return rst;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            rst.add(level);
        }
        Collections.reverse(rst);
        return rst;

    }
}
