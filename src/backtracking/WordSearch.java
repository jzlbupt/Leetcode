package backtracking;

/**
 * Created by ziljin on 14/09/2017.
 */

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0|| word == null ) return false;
        if( word.length() == 0) return true;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++ ) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean rst = dfs(board, i, j, word, 0);
                    if(rst) return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board, int row, int col, String word, int pos) {
        if(pos == word.length()) {
            return true;
        }
        if(row < 0 || row > board.length || col < 0 || col > board[0].length
                || board[row][col] != word.charAt(pos)) {
            return false;
        }
        board[row][col] = '#';
        boolean rst = dfs(board, row + 1, col, word, pos+1) ||
                dfs(board, row -1, col, word, pos + 1) ||
                dfs(board, row, col +1, word, pos + 1) ||
                dfs(board, row, col -1, word, pos + 1);
        board[row][col] = word.charAt(pos);
        return rst;
    }
}
