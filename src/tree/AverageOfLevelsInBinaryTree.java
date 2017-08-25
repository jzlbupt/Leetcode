package tree;

/**
 * Created by ziljin on 25/08/2017.
 */

import java.util.*;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

 Example 1:
 Input:
      3
     / \
    9  20
   /  \
 15   7
 Output: [3, 14.5, 11]

 Explanation:
 The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

 Note:
 The range of node's value is in the range of 32-bit signed integer.

 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<Double> rst = new LinkedList<Double>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            double avg = 0;
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                avg += node.val*1.0/size;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            rst.add(avg);
        }
        return rst;
    }
}
