package backtracking;

/**
 * Created by ziljin on 22/09/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueens2 {
    private int count = 0;
    public int totalNQueens(int n) {
        if(n <= 0) return 0;
        dfs(n, new ArrayList<Integer>());
        return count;
    }

    private void dfs(int n, List<Integer> cols) {
        if(cols.size() == n){
            count ++;
            return;
        }

        for(int i=0; i<n; i++) {
            if(isValid(cols, n, i)) {
                cols.add(i);
                dfs(n, cols);
                cols.remove(cols.size() -1 );
            }
        }
    }

    private boolean isValid(List<Integer> cols, int n, int column) {
        int row = cols.size();
        for(int i=0; i<row; i++) {
            if(i + cols.get(i) == row + column) return false;
            if(i - cols.get(i) == row - column) return false;
            if(cols.get(i) == column) return false;
        }
        return true;
    }



    public int totalNQueens2(int n) {
        dfs2(n, 0, 0, 0, 0);
        return count;
    }

    /**
     *
     * @param n
     * @param row
     * @param column
     * @param diag(\) (n-1 + row -count) of diag represents the diag that queens placed at.
     *                Actually row - count is enough to justify if the queens are placed at,
     *                it can be negative if not add n-1
     * @param antiDiag(/) (row + count) of antiDiag represents the antiDiag that queens placed at.
     *
     *                 eg, n = 4 , antiDiag           diag
     *                 row\col: 0 1 2 3                0 1 2 3
     *                 =================            ===========
     *                       0 |0 1 2 3             0 |3 2 1 0
     *                       1 |1 2 3 4             1 |4 3 2 1
     *                       2 |2 3 4 5             2 |5 4 3 2
     *                       3 |3 4 5 6             3 |6 5 4 3
     */
    private void dfs2(int n, int row, int column, int diag, int antiDiag) {
        if(row == n) {
            count ++;
            return;
        }
        for(int i=0; i<n; i++) {
            boolean isColumnSafe = ((1<<i) & column) == 0 ;
            boolean isDiagSafe = (1<<(n-1 + row - i) & diag) == 0;
            boolean isAntiDiagSafe = (1<<(row + i) & antiDiag) == 0;
            if(isColumnSafe && isDiagSafe && isAntiDiagSafe) {
                dfs2(n, row+1, (1<<i) | column, 1<<(n-1 + row - i) | diag,
                        1<<(row + i) | antiDiag);
            }
        }
    }

    public static void main(String args[]) {
        int n = 8;
        System.out.println(new NQueens2().totalNQueens2(n));
    }
}
