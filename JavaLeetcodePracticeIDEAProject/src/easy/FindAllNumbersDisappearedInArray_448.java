package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 */

public class FindAllNumbersDisappearedInArray_448 {

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        // use an array to count
        int[] counter = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]-1]++;
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0) {
                answer.add(i+1);
            }
        }
        return answer;
    }
    /**
     * pass
     * 执行用时 :5 ms, 在所有 Java 提交中击败了98.70%的用户
     * 内存消耗 :46.7 MB, 在所有 Java 提交中击败了93.49%的用户
     */
}
