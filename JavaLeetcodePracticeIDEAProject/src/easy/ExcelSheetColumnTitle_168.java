package easy;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 * Input: 1
 * Output: "A"
 * Example 2:
 * Input: 28
 * Output: "AB"
 * Example 3:
 * Input: 701
 * Output: "ZY"
 */

public class ExcelSheetColumnTitle_168 {

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }

    public static String convertToTitle(int n) {
        StringBuilder answer = new StringBuilder();
        int modNum;
        while (n > 0) {
            // 从1开始，要--
            n--;
            modNum = n - (n/26) * 26;
            answer.insert(0,(char) (modNum+65));
            n /= 26;
        }
        return answer.toString();
    }
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :33.8 MB, 在所有 Java 提交中击败了54.03%的用户
     */
}
