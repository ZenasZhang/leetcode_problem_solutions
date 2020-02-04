package easy;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and
 * appending multiple copies of the substring together. You may assume the given string consists
 * of lowercase English letters only and its length will not exceed 10000.
 *
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

public class RepeatedSubstringPattern_459 {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abababababab"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len == 1) return false;
        StringBuilder pattern = new StringBuilder();
        int patternLen;
        String strPattern;
        boolean isMatch = true;
        for (int i = 0; i < Math.ceil(len/2); i++) {
            pattern.append(s.charAt(i));
            patternLen = pattern.length();
            strPattern = pattern.toString();
            if (len%patternLen == 0) {
                for (int j = 0; j < len - patternLen + 1; j+=patternLen) {
                    if (!s.substring(j,j+patternLen).equals(strPattern)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) return true;
            }
            isMatch = true;
        }
        return false;
    }
    /**
     * pass
     * 执行用时 :80 ms, 在所有 Java 提交中击败了21.34%的用户
     * 内存消耗 :38.2 MB, 在所有 Java 提交中击败了18.31%的用户
     */


    /**
     *  脑筋急转弯算法
     * 1.将原字符串给出拷贝一遍组成新字符串；
     * 2.掐头去尾留中间；
     * 3.如果还包含原字符串，则满足题意。
     * 假设给定字符串s可由一个子串x重复n次构成，即s=nx。 现构造新字符串t=2s，即两个s相加，由于s=nx，则t=2nx。
     * 去掉t的开头与结尾两位，则这两处的子串被破坏掉，此时t中包含2n-2个子串。
     * 由于t中包含2n-2个子串，s中包含n个子串，若t中包含s，则有2n-2>=n，可得n>=2，由此我们可知字符串s可由一个子串x重复至少2次构成，
     * 判定为true；反之，若t中不包含s，则有2n-2 < n，可得n<2，n只能为1，由此我们可知字符串s=x，假定的子串就为s本身，判定为false。
     */
    public static boolean repeatedSubstringPattern2(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
