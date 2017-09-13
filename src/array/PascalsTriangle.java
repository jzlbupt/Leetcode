package array;

/**
 * Created by ziljin on 12/09/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> previous = new ArrayList<>();
        previous.add(1);
        if(numRows == 0) return rst;
        rst.add(new ArrayList<Integer>(previous));
        if(numRows == 1) {
            return rst;
        }
        for(int i=1; i<numRows; i++) {
            List<Integer> toAdd = new ArrayList<Integer>();
            List<Integer> tmp = rst.get(rst.size() -1);
            toAdd.add(1);
            for(int j=1; j<tmp.size(); j++) {
                toAdd.add(tmp.get(j) + tmp.get(j-1));
            }
            toAdd.add(1);
            rst.add(new ArrayList<>(toAdd));
        }
        return rst;
    }
    public static void main(String args[]) {
        List<List<Integer>> rst = new PascalsTriangle().generate(5);
        System.out.println();
    }
}
