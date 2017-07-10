package twopointers;

/**
 * Created by ziljin on 10/07/2017.
 */

/**
 * Given a string S and a string T, find the minimum window in S which will contain all
 * the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // i : end of the window;
        // j : start of the window
        int i=0, j=0;
        int[] map = new int[256];
        int tNum = initT(t, map);
        int sNum = 0; // count of target character in the window
        int min = Integer.MAX_VALUE;
        String rst = "";
        for(;i<s.length(); i++) {
            if(map[s.charAt(i)] > 0){
                sNum ++;
            }
            // count in map: minus one when the character go into the window;
            //               plus one out of the window
            map[s.charAt(i)]--;
            while(sNum >= tNum){
                if(i-j+1 < min){
                    min = i-j+1;
                    rst = s.substring(j, i+1);
                }
                map[s.charAt(j)]++;
                if(map[s.charAt(j)] > 0){
                    sNum --;
                }
                j++;
            }
        }
        return rst;
    }


    /**
     * Init map using target string s
     * @param s target string s
     * @param map store count of each character c in string s.
     * @return target string numbers, ie, length of s
     */
    private int initT(String s, int[] map) {
        int tNum = 0;
        for(char c : s.toCharArray()) {
            map[c]++;
            tNum ++;
        }
        return tNum;
    }

    public static void main(String args[]) {
        String s = "ADOBECDDEBANC";
        String t = "ABBC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }
}
