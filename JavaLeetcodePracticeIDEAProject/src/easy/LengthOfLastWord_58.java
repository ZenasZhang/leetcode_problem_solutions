package easy;

import java.util.Arrays;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 * Input: "Hello World"
 * Output: 5
 */

public class LengthOfLastWord_58 {

    public static void main(String[] args) {
        System.out.println(" a ".trim());
        System.out.println(lengthOfLastWord2(" a "));
    }

    public static int lengthOfLastWord(String s) {
        s.trim();
        if (s.length() == 0) {
            return 0;
        }
        String[] list = s.split(" ");
        if (list.length == 0) {
            return 0;
        }
        return list[list.length-1].length();
    }

    public static int lengthOfLastWord2(String s) {
        int answer = 0;
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        for (int i = s.length()-1; i > -1; i--) {
            if (s.charAt(i) != ' ') {
                answer++;
            }else {
                break;
            }
        }
        return answer;
    }
    /**
     * pass
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :36.1 MB, 在所有 java 提交中击败了61.06%的用户
     */
}
