package easy;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */

public class MaxConsecutiveOnes_485 {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int answer = 0;
        int currentLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentLen++;
            } else {
                if (currentLen > answer) {
                    answer = currentLen;
                }
                currentLen = 0;
            }
        }
        if (currentLen > answer) {
            answer = currentLen;
        }
        return answer;
    }
    /**
     * pass
     * 执行用时 :2 ms, 在所有 Java 提交中击败了99.95%的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了5.04%的用户
     */
}
