package dynamicprogramming;

/**
 * Created by ziljin on 19/09/2017.
 */

import tree.CountCompleteTreeNodes;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

 Example:
 Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100,
 excluding [11,22,33,44,55,66,77,88,99])
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 0;
        if(n == 1) return 10;
        int base = 9;
        int rst = 10;
        for(int i=0; i<n-1; i++) {
            base = base * (9 -i);
            rst = rst + base;
        }
        return rst;
    }
    public static void main(String args[]) {
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(3));
    }
}
