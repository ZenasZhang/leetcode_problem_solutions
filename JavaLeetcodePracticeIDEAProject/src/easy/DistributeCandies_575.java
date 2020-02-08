package easy;

import java.util.HashSet;

/**
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies.
 * Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister.
 * Return the maximum number of kinds of candies the sister could gain.
 * Example 1:
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 * The sister has three different kinds of candies.
 * Example 2:
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 * The sister has two different kinds of candies, the brother has only one kind of candies.
 * Note:
 * The length of the given array is in range [2, 10,000], and will be even.
 * The number in given array is in range [-100,000, 100,000].
 */

public class DistributeCandies_575 {

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1,2,4,4,4,5,4,4,3,3,3,4,4,3,2,1,2,23,23}));
    }

    public static int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : candies) set.add(new Integer(i));
        return Math.min(set.size(), candies.length / 2);
    }
    /**
     * pass
     * 执行用时 : 33 ms , 在所有 Java 提交中击败了 94.62% 的用户
     * 内存消耗 : 39.8 MB , 在所有 Java 提交中击败了 98.99% 的用户
     */
}
