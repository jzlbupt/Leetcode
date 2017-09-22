package backtracking;

/**
 * Created by ziljin on 21/09/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that
 * no two queens attack each other.

 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement,
 where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]

 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> rst = new ArrayList<>();
        if(n <=0) return rst;
        List<Integer> cols = new ArrayList<>(); // index represents row, value represents column
        solve(rst, cols, n);
        return rst;
    }

    private void solve(List<List<String>> rst, List<Integer> cols, int n) {
        if(cols.size() == n) {
            List<String> tmp = construct(cols);
            rst.add(tmp);
            return;
        }
        for(int colIndex=0; colIndex<n; colIndex++) {
            if(!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            solve(rst, cols, n);
            cols.remove(cols.size() - 1);
        }

    }

    /**
     *
     * @param cols The index of cols represents the rowIndex, the value of rowIndex represents the colIndex on rowIndex
     * @param column Next column will be added to cols, represents column index of the row( cols.size())
     *
     *               eg. List<Integer> : [ 1, 3] column : 2
     *               Queens are placed like :
     *                               rowIndex            cols.get(rowIndex)
     *                                  0       . Q . .       1
     *                                  1       . . . Q       3
     *                                  2(row) [. . Q .]      2(column)  <= decide if this is valid location
     * @return
     */
    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();  // row = 2
        for(int rowIndex = 0; rowIndex < row; rowIndex ++) {
            if(cols.get(rowIndex) == column) {  // different column index
                return false;
            }
            // another version of : row - rowIndex == cols.get(rowIndex) - column
            if(rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            // another version of : row - rowIndex == column - cols.get(rowInde)
            if(rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        return true;
    }

    private List<String> construct(List<Integer> cols) {
        List<String> rst = new ArrayList<>();
        for(int i=0; i<cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<cols.size(); j++) {
                sb.append(j == cols.get(i) ? "Q" : ".");
            }
            rst.add(sb.toString());
        }
        return rst;
    }

    public static void main(String args[]) {
        List<List<String>> rst = new NQueens().solveNQueens(8);
        System.out.println(0);
    }

}
