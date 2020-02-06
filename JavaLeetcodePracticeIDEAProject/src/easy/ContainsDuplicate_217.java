package easy;

import java.util.HashSet;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * <p>
 * Example 1:
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */

public class ContainsDuplicate_217 {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 3, 4, 2}));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        return nums.length - set.size() != 0;
    }
    /**
     * pass
     * 执行用时 :9 ms, 在所有 Java 提交中击败了74.06%的用户
     * 内存消耗 :42.9 MB, 在所有 Java 提交中击败了52.14%的用户
     */

}
