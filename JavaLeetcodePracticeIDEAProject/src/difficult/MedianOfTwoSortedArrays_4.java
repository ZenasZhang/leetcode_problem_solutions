package difficult;

import java.util.ArrayList;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 *
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
        int[] a = new int[]{1,3};
        int[] b = new int[]{2};
        System.out.println(connect(a,b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1==0){
            if(len2%2==0){
                return (double) (nums2[len2/2]+nums2[len2/2 - 1]) / 2;
            }else {
                return nums2[(len2 - 1)/2];
            }
        }
        if (len2==0){
            if(len1%2==0){
                return (double) (nums1[len1/2]+nums1[len1/2 - 1]) / 2;
            }else {
                return nums1[(len1 - 1)/2];
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
        if(connectedSize%2==0){
            return (double) (connectedList.get(connectedSize/2)+connectedList.get(connectedSize/2 - 1)) / 2;
        }else {
            return connectedList.get((connectedSize - 1)/2);
        }
    }

    public static ArrayList<Integer> connect(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
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
        return connectedList;
    }
}
