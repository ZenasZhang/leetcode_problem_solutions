package easy;

/**
 * Given a matrix A, return the transpose of A.
 * The transpose of a matrix is the matrix flipped over it's main diagonal,
 * switching the row and column indices of the matrix.
 *
 * Example 1:
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 *  
 * Note:
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 */

public class TransposeMatrix_867 {

    public static void main(String[] args) {
        System.out.println();
    }

    public static int[][] transpose(int[][] A) {
        int height = A.length;
        int width = A[0].length;
        int[][] answer = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                answer[i][j] = A[j][i];
            }
        }
        return answer;
    }
    /**
     * pass
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 38.5 MB , 在所有 Java 提交中击败了 90.04% 的用户
     */
}
