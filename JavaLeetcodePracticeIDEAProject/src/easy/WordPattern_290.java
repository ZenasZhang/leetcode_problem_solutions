package easy;
/*
Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:
Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:
Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:
Input: pattern = "abba", str = "dog dog dog dog"
Output: false

Notes:
You may assume pattern contains only lowercase letters,
and str contains lowercase letters that may be separated by a single space.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class WordPattern_290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat og"));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] wordList = str.split(" ");
        if (pattern.length() != wordList.length) {
            return false;
        }
        StringBuilder uniquePatterns = new StringBuilder();
        ArrayList<String> uniqueWords = new ArrayList<>();
        HashMap<String,String> match = new HashMap<>();
        String singlePattern;
        String singleWord;
        // ensure that every different pattern character point to one different word
        for (int i = 0; i < pattern.length(); i++) {
            singlePattern = String.valueOf(pattern.charAt(i));
            singleWord = wordList[i];
            // if next pattern character is not in the StringBuilder
            if(uniquePatterns.indexOf(singlePattern) == -1){
                match.put(singlePattern,singleWord);
                uniquePatterns.append(singlePattern);
                if (uniqueWords.contains(singleWord)) {
                    return false;
                }
                uniqueWords.add(singleWord);
            }else {
                if (!match.get(singlePattern).equals(singleWord)) {
                    return false;
                }
            }
        }
        return true;
    }
    /*
    pass
    执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
    内存消耗 :34.3 MB, 在所有 java 提交中击败了35.88%的用户
     */
}
