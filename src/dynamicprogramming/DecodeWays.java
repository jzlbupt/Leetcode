package dynamicprogramming;

/**
 * Created by ziljin on 26/09/2017.
 */

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int nums[] = new int[s.length() + 1];
        nums[0] = 1;
        nums[1] = s.charAt(0) == '0' ? 0:1;
        for(int i=2; i<=s.length(); i++) {
            if(s.charAt(i) != '0'){
                nums[i] = nums[i-1];
            }
            int twoDigits = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
            if(twoDigits >= 10 && twoDigits <=26) {
                nums[i] += nums[i-1];
            }
        }
        return nums[s.length()];
    }
}
