package twopointers;

/**
 * Created by ziljin on 03/07/2017.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<Character>();
        int i=0, j=0, maxLen = 0;
        // two pointers: pointer i represents the start character
        //               pointer j represents the end character
        while(j<s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLen = Math.max(maxLen, set.size());
            } else{
                set.remove(s.charAt(i++));
            }
        }
        return maxLen;
    }
    public static void main(String args[]) {
        String str = "bbbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(str));
    }
}
