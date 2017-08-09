package tree;

/**
 * Created by ziljin on 09/08/2017.
 */

/**
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have
 the same value.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if((p == null && q != null) || (p != null && q == null) )return false;
        else{
            TreeNode pLeft = p.left, pRight = p.right, qLeft = q.left, qRight = q.right;
            if (p.val == q.val){
                return isSameTree(pLeft, qLeft) && isSameTree(pRight, qRight);
            }else{
                return false;
            }
        }
    }
}
