package easy;

import java.math.BigInteger;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

public class ClimbingStairs_70 {

    public static void main(String[] args) {
        System.out.println(climbStairs2(45));
    }

    // 排列组合
    // the answer is n + (n-1 1) + (n-2 2) + ...
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int answer = 1;
        int total = n - 1;
        int take = 1;
        while (total >= take) {
            BigInteger numerator = new BigInteger("1");
            BigInteger denominator = new BigInteger("1");
            for (int i = 0; i < total - take; i++) {
                numerator = numerator.multiply(new BigInteger((total - i) + ""));
                denominator = denominator.multiply(new BigInteger((total - take - i) + ""));
            }
            answer += numerator.divide(denominator).intValue();
            total--;
            take++;
        }
        return answer;
    }

    /**
     * pass
     * 执行用时 :11 ms, 在所有 java 提交中击败了15.75%的用户
     * 内存消耗 :36.8 MB, 在所有 java 提交中击败了5.02%的用户
     */

    //尝试动态规划
    public static int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
