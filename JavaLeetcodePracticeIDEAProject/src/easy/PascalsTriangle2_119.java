package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 * Input: 3
 * Output: [1,3,3,1]
 */

public class PascalsTriangle2_119 {

    public static void main(String[] args) {
        System.out.println();
    }

    public static List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<List<Integer>> answer = new ArrayList<>();
        if (rowIndex == 0) {
            return answer.get(answer.size()-1);
        }
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        answer.add(row1);
        if (rowIndex == 1) {
            return answer.get(answer.size()-1);
        }
        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        answer.add(row2);
        if (rowIndex == 2) {
            return answer.get(answer.size()-1);
        }
        for (int i = 2; i < rowIndex; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            List<Integer> preRow = answer.get(i-1);
            for (int j = 1; j < i; j++) {
                newRow.add(preRow.get(j-1)+preRow.get(j));
            }
            newRow.add(1);
            answer.add(newRow);
        }
        return answer.get(answer.size()-1);
    }
    /**
     * pass
     * 执行用时 :2 ms, 在所有 java 提交中击败了67.27%的用户
     * 内存消耗 :34.4 MB, 在所有 java 提交中击败了21.84%的用户
     */
}
