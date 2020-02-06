package easy;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 * Example 1:
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 * Input: "here"
 * Output: "here"
 * Example 3:
 * Input: "LOVELY"
 * Output: "lovely"
 */

public class ToLowerCase_709 {

    public static void main(String[] args) {
        System.out.println(toLowerCase("GHHGHGKHVi"));
    }

    public static String toLowerCase(String str) {
        if (str.length()==0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char)(c + 32));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
    /**
     * pass
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :34.1 MB, 在所有 Java 提交中击败了58.51%的用户
     */
}
