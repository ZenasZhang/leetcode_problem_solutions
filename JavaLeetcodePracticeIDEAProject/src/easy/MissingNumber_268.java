package easy;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

public class MissingNumber_268 {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    public static int missingNumber(int[] nums) {
        // first add them all
        int sum = 0;
        int desiredSum = 0;
        for (int a : nums) sum += a;
        for (int i = 0; i < nums.length+1; i++) desiredSum += i;
        // O(2n)
        return desiredSum - sum;
    }
    /**
     * pass
     * 执行用时 :1 ms, 在所有 Java 提交中击败了89.79%的用户
     * 内存消耗 :39.3 MB, 在所有 Java 提交中击败了31.08%的用户
     */
}
