package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class PascalsTriangle_118 {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    // 动态规划
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        if (numRows == 0) {
            return answer;
        }
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        answer.add(row1);
        if (numRows == 1) {
            return answer;
        }
        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        answer.add(row2);
        if (numRows == 2) {
            return answer;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            List<Integer> preRow = answer.get(i-1);
            for (int j = 1; j < i; j++) {
                newRow.add(preRow.get(j-1)+preRow.get(j));
            }
            newRow.add(1);
            answer.add(newRow);
        }
        return answer;
    }
    /**
     * 执行用时 :1 ms, 在所有 java 提交中击败了98.18%的用户
     * 内存消耗 :33.9 MB, 在所有 java 提交中击败了26.34%的用户
     */
}
