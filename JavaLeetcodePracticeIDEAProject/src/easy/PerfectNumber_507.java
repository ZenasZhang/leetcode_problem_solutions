package easy;

/**
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * <p>
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * <p>
 * Note: The input number n will not exceed 100,000,000. (1e8)
 */

public class PerfectNumber_507 {

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }

    public static boolean checkPerfectNumber(int num) {
        if (num % 2 == 1) return false; // odd numbers can't be perfect numbers
        int compareNum = 3;
        for (int i = 3; i < num / 2 + 1; i++) {
            if (num % i == 0) compareNum += i;
        }
        return num == compareNum;
    }
    /**
     * pass
     * 执行用时 :748 ms, 在所有 Java 提交中击败了25.00%的用户
     * 内存消耗 :33 MB, 在所有 Java 提交中击败了81.22%的用户
     */
}
