package easy;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do
 * this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example 1:
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */

public class ReverseString_344 {

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        int len = s.length;
        if (len==0 || len==1){
            return;
        }else if (len%2==0){
            // create double pointers "front" and "back"
            char front;
            char back;
            for (int i = 0; i < len / 2; i++) {
                front = s[i];
                back = s[len - i - 1];
                s[i] = back;
                s[len - i - 1] = front;
            }
        } else if (len%2==1) {
            char front;
            char back;
            for (int i = 0; i < (len - 1) / 2; i++) {
                front = s[i];
                back = s[len - i - 1];
                s[i] = back;
                s[len - i - 1] = front;
            }
        }
    }
    /**
     * pass
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :51.7 MB, 在所有 java 提交中击败了79.54%的用户
     */
}
