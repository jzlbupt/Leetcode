package backtracking;

/**
 * Created by ziljin on 21/09/2017.
 */

import java.util.HashMap;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

 Empty cells are indicated by the character '.'.

 You may assume that there will be only one unique solution.


 A sudoku puzzle...


 ...and its solution numbers marked in red.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == '.') {
                    for(char num = '1'; num<='9' ; num ++) {
                        if(isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if(solve(board)) {
                                return true;
                            }else {
                                board[i][j] = '.';
                            }
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for(int i=0; i<9; i++) {
            if(board[i][col] == c) return false;
            if(board[row][i] == c) return false;
            if(board[i/3 + 3*(row/3)][3*(col/3) + i%3] == c) return false;
        }
        return true;
    }
}
