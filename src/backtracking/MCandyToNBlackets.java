package backtracking;

/**
 * Created by ziljin on 17/08/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 将 M 个同样的糖果放在 N 个同样的篮子里，允许有的篮子空着不放，共有多少种不同的分法？
 * （审题有误，下面的解法是“求出所有的分法”）
 比如，把 7 个糖果放在 3 个篮子里，共有 8 种分法（每个数表示篮子中放的糖果数，数的个数为篮子数）：
 1 1 5
 1 2 4
 1 3 3
 2 2 3
 2 5 0
 3 4 0
 6 1 0
 7 0 0

 注意：相同的分布，顺序不同也只算作一种分法，如 7 0 0、0 7 0 和 0 0 7 只算作一种。

 */
public class MCandyToNBlackets {
    private int candy = 0;
    private int blacket = 0;

    public List<List<Integer>> splitCandy(int m, int n){
        this.candy = m;
        this.blacket = n;
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        helper(m, 0, rst, tmp);
        return rst;
    }
    private void helper(int pCandy, int pBlacket, List<List<Integer>> rst, List<Integer> tmp) {
        if(pBlacket == this.blacket -1){
            if(pCandy < tmp.get(tmp.size()-1)){
                return;
            }
            tmp.add(pCandy);
            rst.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size()-1);
            return;
        }
        for(int i=0; i<pCandy; i++){
            if(!tmp.isEmpty() && i<tmp.get(tmp.size()-1)){
                continue;
            }
            tmp.add(i);
            int c = pCandy -i;
            int b = pBlacket + 1;
            helper(c, b, rst, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
    public static void main(String args[]) {
        int m = 7, n=3;
        List<List<Integer>> rst = new MCandyToNBlackets().splitCandy(m, n);

    }
}
