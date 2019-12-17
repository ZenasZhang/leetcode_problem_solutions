package difficult;

import java.util.ArrayList;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */

public class MedianOfTwoSortedArrays_4 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        int[] b = new int[]{2, 5, 8, 10};
        System.out.println(findMedianSortedArrays2(a, b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0) {
            if (len2 % 2 == 0) {
                return (double) (nums2[len2 / 2] + nums2[len2 / 2 - 1]) / 2;
            } else {
                return nums2[(len2 - 1) / 2];
            }
        }
        if (len2 == 0) {
            if (len1 % 2 == 0) {
                return (double) (nums1[len1 / 2] + nums1[len1 / 2 - 1]) / 2;
            } else {
                return nums1[(len1 - 1) / 2];
            }
        }

        // first I connect two list together
        int index1 = 0;
        int index2 = 0;
        ArrayList<Integer> connectedList = new ArrayList<>();
        while (true) {
            if (nums1[index1] >= nums2[index2]) {
                connectedList.add(nums2[index2]);
                index2++;
                if (index2 == len2) {
                    for (int i = index1; i < len1; i++) {
                        connectedList.add(nums1[i]);
                    }
                    break;
                }
            } else {
                connectedList.add(nums1[index1]);
                index1++;
                if (index1 == len1) {
                    for (int i = index2; i < len2; i++) {
                        connectedList.add(nums2[i]);
                    }
                    break;
                }
            }
        }
        int connectedSize = connectedList.size();
        if (connectedSize % 2 == 0) {
            return (double) (connectedList.get(connectedSize / 2) + connectedList.get(connectedSize / 2 - 1)) / 2;
        } else {
            return connectedList.get((connectedSize - 1) / 2);
        }
    }

    /**
     * O(m+n)
     * pass
     * 执行用时 :5 ms, 在所有 java 提交中击败了30.24%的用户
     * 内存消耗 :45 MB, 在所有 java 提交中击败了99.47%的用户
     */

    // a bit optimize
    // return result as soon as finding the median
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0) {
            if (len2 % 2 == 0) {
                return (double) (nums2[len2 / 2] + nums2[len2 / 2 - 1]) / 2;
            } else {
                return nums2[(len2 - 1) / 2];
            }
        }
        if (len2 == 0) {
            if (len1 % 2 == 0) {
                return (double) (nums1[len1 / 2] + nums1[len1 / 2 - 1]) / 2;
            } else {
                return nums1[(len1 - 1) / 2];
            }
        }

        int index1 = 0;
        int index2 = 0;
        int connectedSize = len1 + len2;
        int curIndex = -1;
        ArrayList<Integer> connectedList = new ArrayList<>();
        if (connectedSize % 2 == 0){
            while (true) {
                if (nums1[index1] >= nums2[index2]) {
                    connectedList.add(nums2[index2]);
                    curIndex++;
                    index2++;
                    if (connectedSize/2 == curIndex) {
                        return (double)(connectedList.get(curIndex) + connectedList.get(curIndex-1))/2;
                    }
                    if (index2 == len2) {
                        for (int i = index1; i < len1; i++) {
                            connectedList.add(nums1[i]);
                        }
                        break;
                    }
                } else {
                    connectedList.add(nums1[index1]);
                    curIndex++;
                    index1++;
                    if (connectedSize/2 == curIndex) {
                        return (double) (connectedList.get(curIndex) + connectedList.get(curIndex-1))/2;
                    }
                    if (index1 == len1) {
                        for (int i = index2; i < len2; i++) {
                            connectedList.add(nums2[i]);
                        }
                        break;
                    }
                }
            }
        } else {
            while (true) {
                if (nums1[index1] >= nums2[index2]) {
                    connectedList.add(nums2[index2]);
                    curIndex++;
                    index2++;
                    if ((connectedSize-1)/2 == curIndex) {
                        return connectedList.get(curIndex);
                    }
                    if (index2 == len2) {
                        for (int i = index1; i < len1; i++) {
                            connectedList.add(nums1[i]);
                        }
                        break;
                    }
                } else {
                    connectedList.add(nums1[index1]);
                    curIndex++;
                    index1++;
                    if ((connectedSize-1)/2 == curIndex) {
                        return connectedList.get(curIndex);
                    }
                    if (index1 == len1) {
                        for (int i = index2; i < len2; i++) {
                            connectedList.add(nums2[i]);
                        }
                        break;
                    }
                }
            }
        }
        if (connectedSize % 2 == 0) {
            return (double) (connectedList.get(connectedSize / 2) + connectedList.get(connectedSize / 2 - 1)) / 2;
        } else {
            return connectedList.get((connectedSize - 1) / 2);
        }
    }
    /**
     * O(m+n)
     * pass
     * 执行用时 :4 ms, 在所有 java 提交中击败了46.13%的用户
     * 内存消耗 :47.9 MB, 在所有 java 提交中击败了92.05%的用户
     */

    /**
     * a solution whose time complexity is O(log(m+n))
     *
     * 假设我们要找第 7 小的数字。
     *
     * 我们比较两个数组的第 k/2 个数字，如果 k 是奇数，向下取整。也就是比较第 33 个数字，上边数组中的 44 和下边数组中的 33，如果哪个小，就表明该数组的前 k/2 个数字都不是第 k 小数字，所以可以排除。也就是 11，22，33 这三个数字不可能是第 77 小的数字，我们可以把它排除掉。将 13491349 和 4567891045678910 两个数组作为新的数组进行比较。
     *
     * 更一般的情况 A[1] ，A[2] ，A[3]，A[k/2] ... ，B[1]，B[2]，B[3]，B[k/2] ... ，如果 A[k/2]<B[k/2] ，那么A[1]，A[2]，A[3]，A[k/2]都不可能是第 k 小的数字。
     *
     * A 数组中比 A[k/2] 小的数有 k/2-1 个，B 数组中，B[k/2] 比 A[k/2] 小，假设 B[k/2] 前边的数字都比 A[k/2] 小，也只有 k/2-1 个，所以比 A[k/2] 小的数字最多有 k/1-1+k/2-1=k-2个，所以 A[k/2] 最多是第 k-1 小的数。而比 A[k/2] 小的数更不可能是第 k 小的数了，所以可以把它们排除。
     *
     * 由于我们已经排除掉了 3 个数字，就是这 3 个数字一定在最前边，所以在两个新数组中，我们只需要找第 7 - 3 = 4 小的数字就可以了，
     * 也就是 k = 4。此时两个数组，比较第 2 个数字，3 < 5，所以我们可以把小的那个数组中的 1 ，3 排除掉了。
     * 我们又排除掉 2 个数字，所以现在找第 4 - 2 = 2 小的数字就可以了。此时比较两个数组中的第 k / 2 = 1 个数，4 == 4，怎么办呢？
     * 由于两个数相等，所以我们无论去掉哪个数组中的都行，因为去掉 1 个总会保留 1 个的，所以没有影响。为了统一，我们就假设 4 > 4 吧，
     * 所以此时将下边的 4 去掉。由于又去掉 1 个数字，此时我们要找第 1 小的数字，所以只需判断两个数组中第一个数字哪个小就可以了，也就是 4。
     * 所以第 7 小的数字是 4。
     *
     * 我们每次都是取 k/2 的数进行比较，有时候可能会遇到数组长度小于 k/2的时候。
     * 此时 k / 2 等于 3，而上边的数组长度是 2，我们此时将箭头指向它的末尾就可以了。
     * 这样的话，由于 2 < 3，所以就会导致上边的数组 1，2 都被排除。造成下边的情况。
     * 由于 2 个元素被排除，所以此时 k = 5，又由于上边的数组已经空了，我们只需要返回下边的数组的第 5 个数字就可以了。
     *
     * 从上边可以看到，无论是找第奇数个还是第偶数个数字，对我们的算法并没有影响，而且在算法进行中，k 的值都有可能从奇数变为偶数，最终都会变为 1 或者由于一个数组空了，直接返回结果。
     *
     * 所以我们采用递归的思路，为了防止数组长度小于 k/2，所以每次比较 min(k/2，len(数组) 对应的数字，把小的那个对应的数组的数字排除，将两个新数组进入递归，并且 k 要减去排除的数字的个数。递归出口就是当 k=1 或者其中一个数字长度是 0 了。
     *
     * 代码
     * public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     *     int n = nums1.length;
     *     int m = nums2.length;
     *     int left = (n + m + 1) / 2;
     *     int right = (n + m + 2) / 2;
     *     //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
     *     return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
     * }
     *
     *     private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
     *         int len1 = end1 - start1 + 1;
     *         int len2 = end2 - start2 + 1;
     *         //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
     *         if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
     *         if (len1 == 0) return nums2[start2 + k - 1];
     *
     *         if (k == 1) return Math.min(nums1[start1], nums2[start2]);
     *
     *         int i = start1 + Math.min(len1, k / 2) - 1;
     *         int j = start2 + Math.min(len2, k / 2) - 1;
     *
     *         if (nums1[i] > nums2[j]) {
     *             return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
     *         }
     *         else {
     *             return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
     *         }
     *     }
     * 时间复杂度：每进行一次循环，我们就减少 k/2 个元素，
     *   所以时间复杂度是 O(log(k)，而 k=(m+n)/2，所以最终的复杂也就是 O(log(m+n）O(log(m+n）。
     * 空间复杂度：虽然我们用到了递归，但是可以看到这个递归属于尾递归，所以编译器不需要不停地堆栈，所以空间复杂度为 O(1)O(1)。
     */
}
