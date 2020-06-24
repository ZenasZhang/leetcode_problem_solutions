package easy;

import java.util.Arrays;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 * Given an array nums representing the data status of this set after the error.
 * Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 *
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 *
 * Note:
 *     The given array size will in the range [2, 10000].
 *     The given array's numbers won't have any order.
 */

public class SetMismatch_645 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
    }

    public static int[] findErrorNums(int[] nums) {
        int[] answer = new int[2];
        int[] statistic = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            statistic[nums[i] - 1]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (statistic[i] == 2) answer[0] = i + 1;
            if (statistic[i] == 0) answer[1] = i + 1;
        }
        return answer;
    }
    /**
     * pass
     * 执行用时：2 ms, 在所有 Java 提交中击败了96.40% 的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了14.29% 的用户
     */
}
