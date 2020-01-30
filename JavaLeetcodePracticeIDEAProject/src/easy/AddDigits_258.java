package easy;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */

public class AddDigits_258 {

    public static void main(String[] args) {
        System.out.println(addDigits(10));
    }

    public static int addDigits(int num) {
        int newNum = 0;
        while (num >= 10) {
            while (num != 0) {
                newNum += num % 10;
                num /= 10;
            }
            num = newNum;
            newNum = 0;
        }
        return num;
    }
    /**
     * pass
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%
     * 的用户内存消耗 :33.6 MB, 在所有 Java 提交中击败了57.59%的用户
     */
}
