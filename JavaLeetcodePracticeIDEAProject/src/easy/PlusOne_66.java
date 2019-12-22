package easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */

public class PlusOne_66 {

    public static void main(String[] args) {
        int[] digits = {9,9,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len-1; i > -1 ; i--) {
            digits[i] = digits[i] + 1;
            if (digits[i]<10) {
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] > 0) {
            return digits;
        } else {
            ArrayList<Integer> ints = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                ints.add(digits[i]);
            }
            ints.add(0,1);
            int[] answer = new int[ints.size()];
            for (int i = 0; i < ints.size(); i++) {
                answer[i] = ints.get(i);
            }
            return answer;
        }
    }
    /**
     * pass
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :34.7 MB, 在所有 java 提交中击败了54.91%的用户
     */
}
