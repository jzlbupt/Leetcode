package twopointers;

/**
 * Created by ziljin on 11/07/2017.
 */

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.

 Example 1:
 Input:s1 = "ab" s2 = "eidbaooo"
 Output:True
 Explanation: s2 contains one permutation of s1 ("ba").
 Example 2:
 Input:s1= "ab" s2 = "eidboaoo"
 Output: False
 Note:
 The input strings only contain lower case letters.
 The length of both given strings is in range [1, 10,000].
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        //initialize
        for(int i=0; i<s1.length(); i++) count[s1.charAt(i)]--;

        for(int l=0, r=0; r<s2.length(); r++) {
            // r_character is not in s1, or [l, r] contains too many r_character.
            if(++count[s2.charAt(r)] > 0) {
                // move left pointer l forward
                while(l<=r){
                    if(--count[s2.charAt(l)] == 0){
                        l++;
                        break;
                    }
                    l++;
                }
            }
            // s1 contains characters within [l, r]
            else if(r-l+1 == s1.length()){
                return true;
            }
        }
        return s1.length() == 0;
    }
    public static void main(String args[]) {
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        System.out.println(new PermutationInString().checkInclusion(s1, s2));
    }
}
