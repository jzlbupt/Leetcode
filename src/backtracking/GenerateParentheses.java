package backtracking;

/**
 * Created by ziljin on 13/09/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<>();
        if(n == 0) return rst;
        StringBuilder sb = new StringBuilder();
        dfs(n, rst, sb, 0, 0);
        return rst;
    }

    private void dfs(int n, List<String> rst, StringBuilder sb, int open, int close) {
        if(sb.length() == 2*n) {
            rst.add(sb.toString());
            return;
        }
        if(open < n) {
            sb.append("(");
            dfs(n, rst, sb, open + 1, close);
            sb.deleteCharAt(sb.length() -1);
        }
        if(close < open) {
            sb.append(")");
            dfs(n, rst, sb, open, close + 1);
            sb.deleteCharAt(sb.length() -1);
        }
    }

    public static void main(String args[]) {
        int n= 3;
        List<String> rst = new GenerateParentheses().generateParenthesis(n);
        System.out.println();
    }
}
