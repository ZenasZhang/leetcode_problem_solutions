package easy;

/**
 * We are given two strings, A and B.
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A.
 * Return True if and only if A can become B after some number of shifts on A.
 *
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 *
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 */

public class RotateString_796 {

    public static void main(String[] args) {
        System.out.println(rotateString("abcde","cdeab"));
    }

    public static boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        int len = A.length();
        if (len == 0) return true;
        for (int i = 1; i < len; i++) {
            if (B.endsWith(A.substring(0,i)) && B.startsWith(A.substring(i,len))) {
                return true;
            }
        }
        return false;
    }

    /**
     * pass
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.4 MB, 在所有 Java 提交中击败了50.00% 的用户
     */
}
