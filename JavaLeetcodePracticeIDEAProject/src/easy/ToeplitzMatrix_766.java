package easy;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *  
 * Example 1:
 * Input:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 * Example 2:
 * Input:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * <p>
 * Note:
 * matrix will be a 2D array of integers.
 * matrix will have a number of rows and columns in range [1, 20].
 * matrix[i][j] will be integers in range [0, 99].
 * <p>
 * Follow up:
 * What if the matrix is stored on disk, and the memory is limited such that you can only load
 * at most one row of the matrix into the memory at once?
 * What if the matrix is so large that you can only load up a partial row into the memory at once?
 */

public class ToeplitzMatrix_766 {

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        if (width == 1 || width == 1) return true;
        for (int i = 0; i < width - 1; i++) {
            for (int j = 1, k = i + 1; k < width && j < height; j++, k++) {
                if (matrix[0][i] != matrix[j][k]) return false;
            }
        }
        for (int i = 1; i < height - 1; i++) {
            for (int j = i + 1, k = 1; k < width && j < height; j++, k++) {
                if (matrix[i][0] != matrix[j][k]) return false;
            }
        }
        return true;
    }
    /**
     * pass
     * 执行用时 :1 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 :42.9 MB, 在所有 Java 提交中击败了 20.96% 的用户
     */
}
