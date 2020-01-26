package easy;

/**
 * Write an algorithm to determine if a number is "happy"
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */

public class HappyNumber_202 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        } else if (n <= 0) {
            return false;
        }
        int currentNum = n;
        int nextNum = 0;
        for (int i = 0; i < 10; i++) {
            while (currentNum > 0) {
                nextNum += (currentNum % 10) * (currentNum % 10);
                currentNum /= 10;
            }
            if (nextNum == 1) {
                return true;
            } else {
                currentNum = nextNum;
                nextNum = 0;
            }
        }
        return false;
    }
    /**
     * pass
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :33.2 MB, 在所有 Java 提交中击败了87.91%的用户
     */
}
