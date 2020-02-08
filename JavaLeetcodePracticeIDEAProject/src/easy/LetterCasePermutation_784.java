package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * Input: S = "12345"
 * Output: ["12345"]
 *
 * Note:
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */

public class LetterCasePermutation_784 {

    public static void main(String[] args) {
        System.out.println(letterCasePermutation2("a1b2"));
    }

    public static List<String> letterCasePermutation(String S) {
        S = S.toLowerCase();
        List<String> list = new ArrayList<>();
        list.add("");
        // 一个char一个char地累加
        for (int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);
            ArrayList<String> insertion = new ArrayList<>();
            // 不管数字还是字母先累加一遍
            for (int j = 0; j < list.size(); j++) {
                String s = list.get(j);
                s += String.valueOf(currentChar);
                insertion.add(s);
            }
            // 如果为小写字母就再累加一次对应的大写字母
            if (currentChar > 96 && currentChar < 123) {
                for (int j = 0; j < list.size(); j++) {
                    String s = list.get(j);
                    s += String.valueOf((char) (currentChar - 32));
                    insertion.add(s);
                }
            }
            list = insertion;
        }
        return list;
    }
    /**
     * pass
     * 执行用时 : 9 ms , 在所有 Java 提交中击败了 33.27% 的用户
     * 内存消耗 : 37 MB , 在所有 Java 提交中击败了 84.92% 的用户
     */

    // 方法二：回溯算法
    public static List<String> letterCasePermutation2(String S) {
        int len = S.length();
        List<String> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        char[] charArray = new char[len];
        dfs(S, 0, len, charArray, res);
        return res;
    }

    private static void dfs(String S, int start, int len, char[] charArray, List<String> res) {
        if (start == len) {
            res.add(new String(charArray));
            return;
        }
        charArray[start] = S.charAt(start);
        dfs(S, start + 1, len, charArray, res);

        // 如果是字符，就可以派生出一个新分支
        if (Character.isLetter(S.charAt(start))) {
            // 这一步直接修改，相当于回溯
            charArray[start] = (char) (S.charAt(start) ^ (1 << 5));
            dfs(S, start + 1, len, charArray, res);
        }
    }
}
