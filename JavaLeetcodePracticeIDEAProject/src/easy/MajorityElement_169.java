package easy;

import java.util.HashMap;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */

public class MajorityElement_169 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,3,2,3,2,2,2}));
    }

    public static int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int halfLen = len/2;
        HashMap<Integer,Integer> elementsAndNUmbers = new HashMap<>();
        int currentElement;
        for (int i = 0; i < len; i++) {
            currentElement = nums[i];
            if (elementsAndNUmbers.containsKey(currentElement)) {
                int a = elementsAndNUmbers.get(currentElement) + 1;
                if (a > halfLen) {
                    return currentElement;
                } else {
                    elementsAndNUmbers.put(currentElement,a);
                }
            } else {
                elementsAndNUmbers.put(currentElement,1);
            }
        }
        return 0;
    }
    /**
     * pass
     * 执行用时 :19 ms, 在所有 java 提交中击败了34.25%的用户
     * 内存消耗 :40 MB, 在所有 java 提交中击败了92.83%的用户
     */

    // 摩尔投票法： 从第一个数字开始，count=1，出现不同的就count--，count等于0就换下一个数
    public static int majorityElement2(int[] nums) {
        int candidate = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else{
                count--;
            }
        }
        return candidate;
    }
}
