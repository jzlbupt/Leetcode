package dynamicprogramming;

/**
 * Created by ziljin on 25/09/2017.
 */

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.


 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int pre1 = 1, pre2 = 1;
        for(int i=2; i<= n; i++) {
            int tmp = pre1;
            pre1 = pre2;
            pre2 = tmp + pre2;
        }
        return pre2;
    }
}
