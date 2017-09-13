package backtracking;

/**
 * Created by ziljin on 13/09/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 1: , 2:abc, 3:def
 4:ghi, 5:jkl, 6:mno
 7:pqrs, 8:tuv, 9:wxyz

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.

 */
public class LetterCombinationsOfAPhoneNumber {
    static HashMap<Integer, String> map = new HashMap<>();
    static {
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

    }
    public List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(rst, digits, 0, sb);
        return rst;
    }
    private void dfs(List<String> rst, String digits, int pos, StringBuilder sb) {
        if(sb.length() == digits.length()) {
            rst.add(sb.toString());
        }
        for(int i=pos; i<digits.length(); i++) {
            int number = Integer.valueOf(digits.charAt(i)+"");
            String str = map.get(number);
            for(int j=0; j<str.length(); j++) {
                sb.append(str.charAt(j));
                dfs(rst, digits, i+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public static void main(String args[]) {
        String digits = "23";
        List<String> rst = new LetterCombinationsOfAPhoneNumber().letterCombinations(digits);
        System.out.println();
    }
}
