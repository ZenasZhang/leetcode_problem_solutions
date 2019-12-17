package easy;

/**
 * Given a sorted array nums, remove the duplicates in-place
 * such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this
 * by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5,
 * with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference,
 * which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */

public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        System.out.println(removeDuplicates(a));
        //removeDuplicates(a);
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len==0){
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        int curNum;
        int index = 0;
        int newIndex = 0;
        int answer = nums.length;
        while (true){
            curNum = nums[index];
            while (true) {
                index++;
                if (curNum == nums[index]) {
                    // 末尾数一定要处理好，否则就会out of bound
                    if (index == len - 1) {
                        nums[newIndex] = nums[index];
                        answer--;
                        return answer;
                    }else {
                        answer--;
                    }
                }else {
                    if (index == len-1) {
                        newIndex++;
                        nums[newIndex] = nums[index];
                        return answer;
                    }
                    else {
                        newIndex++;
                        nums[newIndex] = nums[index];
                        break;
                    }
                }
            }
            //处理末尾数
            if (index == len-1) {
                newIndex++;
                nums[newIndex] = nums[index];
                return answer;
            }
        }
    }

    /**
     * pass
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :39.6 MB, 在所有 java 提交中击败了95.81%的用户
     */
}
