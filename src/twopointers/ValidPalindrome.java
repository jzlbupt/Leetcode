package twopointers;

/**
 * Created by ziljin on 06/07/2017.
 */

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and
 * ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0 || s.length() == 1) return true;
        s = s.toLowerCase().trim();
        int len = s.length();
        int i=0, j=len-1;
        while(i<=j){
            while(i<=j && !isNumberOrChar(s.charAt(i))) i++;
            while(i<=j && !isNumberOrChar(s.charAt(j))) j--;
            if(i<=j){
                if(s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                }else {
                    return false;
                }
            }else{
                return true;
            }
        }
        return true;
    }
    private boolean isNumberOrChar(Character c) {
        return (c>='a' && c<='z') || (c>='0' && c<='9');
    }
    public static void main(String args[]) {
        String s = "a.";
        System.out.println(new ValidPalindrome().isPalindrome(s));
    }
}
