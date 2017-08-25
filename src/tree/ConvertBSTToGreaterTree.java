package tree;

/**
 * Created by ziljin on 25/08/2017.
 */

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
     5
   /   \
 2     13

 Output: The root of a Greater Tree like this:
     18
   /   \
 20     13

 */
public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;

    }

    /**
     * calculate the value need to be added to the left child of root.
     * @param root current node
     * @param val current value to be added to the root
     * @return value to be added to the left child of root
     */
    private int dfs(TreeNode root, int val){
        if(root == null) return val;
        int right = dfs(root.right, val);
        int left = dfs(root.left, right + root.val);
        root.val = right + root.val;
        return left;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root = new ConvertBSTToGreaterTree().convertBST(root);
    }
}


