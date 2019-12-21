package easy;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 */

public class SearchInsertPosition_35 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,7));
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target > nums[i]) {
                continue;
            } else {
                return i;
            }
        }
        return nums.length;
    }
    /**
     * pass
     * 执行用时 : 0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :38.8 MB, 在所有 java 提交中击败了59.59%的用户
     */
}
