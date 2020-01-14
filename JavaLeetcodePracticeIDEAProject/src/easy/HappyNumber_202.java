package easy;

/**
 * Write an algorithm to determine if a number is "happy"
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */

public class HappyNumber_202 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        int len;
        int changedN = 0;
        for (int j = 0; j < 100; j++) {
            len = String.valueOf(n).length();
            for (int i = 0; i < len; i++) {
                changedN += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (changedN == 1) {
                return true;
            } else {
                n = changedN;
            }
        }
        return false;
    }
}
