package backtracking;

/**
 * Created by ziljin on 14/09/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) return rst;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<=i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i-j<=2 || isPalindrome[j+1][i-1])) {
                    isPalindrome[j][i] = true;
                }
            }
        }
        List<String> tmp = new ArrayList<>();
        helper(s, rst, tmp, isPalindrome, 0);
        return rst;
    }
    private void helper(String s, List<List<String>> rst, List<String> tmp, boolean[][] isPalindrome, int pos) {
        if(pos == s.length()) {
            rst.add(new ArrayList<>(tmp));
            return ;
        }
        for(int i=pos; i<s.length(); i++) {
            if(isPalindrome[pos][i]){
                tmp.add(s.substring(pos, i+1));
                helper(s, rst, tmp, isPalindrome, i+1);
                tmp.remove(tmp.size() -1);
            }
        }
    }

    public static void main(String args[]) {
        String s = "aaaaaba";
        List<List<String>> rst = new PalindromePartitioning().partition(s);
        System.out.println();
    }
}
