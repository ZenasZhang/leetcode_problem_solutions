package easy;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 *
 * Example:
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 */

public class MergeSortedArray_88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int newIndex = 0;
        int index1 = 0;
        int index2 = 0;
        int[] answer = new int[m+n];
        // 冒泡排序
        while (true) {
            if (nums1[index1] >= nums2[index2]) {
                answer[newIndex] = nums2[index2];
                newIndex++;
                index2++;
                if (index2 == n) {
                    for (int i = index1; i < m; i++) {
                        answer[newIndex] = nums1[i];
                        newIndex++;
                    }
                    break;
                }
            } else {
                answer[newIndex] = nums1[index1];
                newIndex++;
                index1++;
                if (index1 == m) {
                    for (int i = index2; i < n; i++) {
                        answer[newIndex] = nums2[i];
                        newIndex++;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < m+n; i++) {
            nums1[i] = answer[i];
        }
        /**
         * pass
         * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
         * 内存消耗 :35.9 MB, 在所有 java 提交中击败了85.96%的用户
         */
    }
}
