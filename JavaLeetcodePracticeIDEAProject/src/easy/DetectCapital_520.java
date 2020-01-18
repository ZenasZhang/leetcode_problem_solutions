package easy;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 */

public class DetectCapital_520 {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("ogle"));
    }

    public static boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        char[] origin = word.toCharArray();
        String lower = word.toLowerCase();
        char[] changed = lower.toCharArray();
        if (origin[0] == changed[0]) {
            for (int i = 1; i < origin.length; i++) {
                if (origin[i] != changed[i]) {
                    return false;
                }
            }
        } else {
            if (origin[1] == changed[1]) {
                if (origin.length == 2) {
                    return true;
                } else {
                    for (int i = 2; i < origin.length; i++) {
                        if (origin[i] != changed[i]) {
                            return false;
                        }
                    }
                }
            } else {
                if (origin.length == 2) {
                    return true;
                } else {
                    for (int i = 2; i < origin.length; i++) {
                        if (origin[i] == changed[i]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    /**
     * pass
     * 执行用时 :2 ms, 在所有 Java 提交中击败了33.76%的用户
     * 内存消耗 :34.7 MB, 在所有 Java 提交中击败了45.11%的用户
     */
}
