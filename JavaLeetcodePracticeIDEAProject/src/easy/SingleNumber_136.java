package easy;

import java.util.ArrayList;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 */

public class SingleNumber_136 {

    public static void main(String[] args) {
        System.out.println(singleNumber2(new int[]{4,1,2,1,2}));
    }

    public static int singleNumber(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (arrayList.remove((Integer) nums[i])) {
                continue;
            } else {
                arrayList.add(nums[i]);
            }
        }
        return arrayList.get(0);
    }
    /**
     * pass but took too much time
     */

    // 异或运算 exclusive OR
    public static int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }
}
