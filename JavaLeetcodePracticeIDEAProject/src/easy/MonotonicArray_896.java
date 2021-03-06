package easy;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].
 * An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 * <p>
 * Example 1:
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 * Input: [1,1,1]
 * Output: true
 *  
 * Note:
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */

public class MonotonicArray_896 {

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{222, 2, -22}));
    }

    public static boolean isMonotonic(int[] A) {
        int len = A.length;
        if (len == 1) return true;
        if (A[0] > A[len - 1]) {
            for (int i = 1; i < len; i++) {
                if (A[i] > A[i - 1]) return false;
            }
        } else {
            for (int i = 1; i < len; i++) {
                if (A[i] < A[i - 1]) return false;
            }
        }
        return true;
    }
    /**
     * pass
     * 执行用时 :2 ms, 在所有 Java 提交中击败了98.34%的用户
     * 内存消耗 :48.2 MB, 在所有 Java 提交中击败了97.61%的用户
     */
}
