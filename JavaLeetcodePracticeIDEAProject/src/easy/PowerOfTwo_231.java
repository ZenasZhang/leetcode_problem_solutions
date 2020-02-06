package easy;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * Example 1:
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 * Input: 218
 * Output: false
 */

public class PowerOfTwo_231 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }

    public static boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
    /**
     * pass
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :33.6 MB, 在所有 Java 提交中击败了45.58%的用户
     */
}
