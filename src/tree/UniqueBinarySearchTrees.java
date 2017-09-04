package tree;

/**
 * Created by ziljin on 28/08/2017.
 */

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

  1         3     3      2      1
   \       /     /      / \      \
   3     2     1      1   3      2
  /     /       \                 \
 2     1         2                 3

 */

// DP problem : f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ... + f(n-1)*f(0);
//        init: f(0) = 0, f(1) = 1;
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] fn = new int[n];
        fn[0] = 1;
        fn[1] = 1;
        for(int i=2; i<n; i++) {
            for(int j=1; j<=i; j++) {
                fn[i] += fn[i-j]*fn[j-1];
            }
        }
        return fn[n-1];
    }
}
