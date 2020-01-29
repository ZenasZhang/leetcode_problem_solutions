package medium;

/**
 * Given an input string, reverse the string word by word.
 * Example 1:
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Note:
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

public class ReverseWordsInAString_151 {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        String[] wordList = s.split(" ");
        StringBuilder answer = new StringBuilder();
        for (int i = wordList.length - 1; i > -1; i--) {
            if (wordList[i].equals("")) {
                continue;
            } else {
                if (i == 0) {
                    answer.append(wordList[i]);
                } else {
                    answer.append(wordList[i]).append(" ");
                }
            }
        }
        return answer.toString();
    }
    /**
     * pass
     * 执行用时 :2 ms, 在所有 Java 提交中击败了99.23%的用户
     * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了97.20%的用户
     */
}
