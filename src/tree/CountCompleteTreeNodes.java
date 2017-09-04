package tree;

/**
 * Created by ziljin on 04/09/2017.
 */

/**
 * Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last, is completely filled,
 and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes
 inclusive at the last level h.
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int rst = 0, h = height(root);
        while(root != null) {
            if(height(root.right) == h-1) {
                rst += 1<<h;
                root = root.right;
            }else {
                rst += 1<<h - 1;
                root = root.left;
            }
            h--;
        }
        return rst;
    }
    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    public int countNodes2(TreeNode root) {
        if(root == null) return 0;
        TreeNode left = root, right = root;
        int height = 0;
        while(right != null) {
            right = right.right;
            left = left.left;
            height ++;
        }
        if(left == null){
            return (1<<height) -1;
        }
        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(new CountCompleteTreeNodes().countNodes(root));
    }
}
