package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their
 * absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 */

public class K_diffPairsInAnArray_532 {

    public static void main(String[] args) {
        System.out.println(findPairs2(new int[]{1, 3, 1, 5, 4}, 0));
    }

    public static int findPairs(int[] nums, int k) {
        if (nums.length < 2) return 0;
        int answer = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + k == nums[j]) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    /**
     * pass
     * 执行用时 : 55 ms , 在所有 Java 提交中击败了 26.27% 的用户
     * 内存消耗 : 39.4 MB , 在所有 Java 提交中击败了 76.79% 的用户
     */

    // method 2
    public static int findPairs2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        if (k < 0) return count;
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        for (int i : map.keySet()) {
            if (k == 0) {
                if (map.get(i) > 1)
                    count++;
            } else if (map.containsKey(i + k)) {
                count++;
            }
        }
        return count;
    }
}
