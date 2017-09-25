package backtracking;

/**
 * Created by ziljin on 25/09/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Note:
 Return an empty list if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> rst = new ArrayList<List<String>>();
        List<String> tmp = new ArrayList<>();
        tmp.add(beginWord);
        dfs(wordList, beginWord, beginWord, endWord, rst, tmp, 0);
        return rst;
    }

    private void dfs(List<String> wordList, String beginWord, String currentWord, String endWord, List<List<String>> rst,
                     List<String> tmp, int pos) {
        if(tmp.get(tmp.size()-1).equals(endWord)) {
            rst.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=pos; i<wordList.size(); i++) {
            if(isValid(currentWord, endWord)) {
                tmp.add(endWord);
                rst.add(new ArrayList<>(tmp));
                return;
            }
            if(isValid(currentWord, wordList.get(i))) {
                tmp.add(wordList.get(i));
                dfs(wordList, beginWord, wordList.get(i), endWord, rst, tmp, pos + 1);
                tmp.remove(tmp.size() -1);
            }
        }
    }

    private boolean isValid(String currentWord, String toAddWord) {
        int count = 0;
        for(int i=0; i<currentWord.length(); i++){
            if(count > 1) return false;
            if(currentWord.charAt(i) != toAddWord.charAt(i)) {
                count ++;
            }
        }
        return count == 1 ? true : false;
    }

    public static void main(String args[]) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        List<List<String>> rst = new WordLadder2().findLadders("hit", "cog", wordList);
        System.out.println();
    }

}
