package backtracking;

/**
 * Created by ziljin on 12/09/2017.
 */

import twopointers.PermutationInString;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 */

// It's a math problem...hmm
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        List<Integer> nums = new ArrayList<Integer>();

        int[] factorial = new int[n+1];
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial = {1, 1, 2, 6, 24..., n!}

        for(int i=1; i<=n; i++){
            nums.add(i);
        }
        // nums = {1,2,3,4,...}

        k--;

        for(int i=1; i<=n; i++){
            int index = k/factorial[n-i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= factorial[n-i] * index;
        }
        return sb.toString();

    }
    public static void main(String args[]) {
        int n=3, k=4;
        System.out.println(new PermutationSequence().getPermutation(n, k));
    }
}
