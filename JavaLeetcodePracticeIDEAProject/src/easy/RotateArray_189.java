package easy;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */

public class RotateArray_189 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        if (k == 0) return;
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            int last = nums[len-1];
            for (int j = len-1; j >= 0; j--) {
                if (j == 0) {
                    nums[0] = last;
                } else {
                    nums[j] = nums[j - 1];
                }
            }
        }
    }
    /**
     * 执行用时 :324 ms, 在所有 java 提交中击败了5.01%的用户
     * 内存消耗 :37.8 MB, 在所有 java 提交中击败了93.50%的用户
     */
}
