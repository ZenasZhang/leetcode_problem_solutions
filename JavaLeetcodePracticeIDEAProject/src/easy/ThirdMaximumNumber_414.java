package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */

public class ThirdMaximumNumber_414 {

    public static void main(String[] args) {
        System.out.println(thirdMax2(new int[]{1,2,-2147483648}));
    }

    public static int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i > -1; i--) {
            set.add(Integer.valueOf(nums[i]));
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        if (list.size() < 3) {
            return list.get(list.size()-1);
        } else {
            return list.get(list.size()-3);
        }
        /**
         * pass
         * 执行用时 :8 ms, 在所有 Java 提交中击败了36.18%的用户
         * 内存消耗 :37.6 MB, 在所有 Java 提交中击败了81.63%的用户
         */
    }

    // try to use O(n) method
    public static int thirdMax2(int[] nums) {
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int secondMax = Integer.MIN_VALUE;
        boolean a = false;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= secondMax && nums[i] < max) {
                secondMax = nums[i];
                a = true;
            }
        }
        if (!a) {
            return max;
        }
        int thirdMax = Integer.MIN_VALUE;
        boolean b = false;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
                b = true;
            }
        }
        if (!b) {
            return max;
        }
        return thirdMax;
    }
    /**
     * pass
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.18%的用户
     * 内存消耗 :37.6 MB, 在所有 Java 提交中击败了76.39%的用户
     */
}
