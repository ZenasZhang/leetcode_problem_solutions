package easy;

/**
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 * 
 * Follow up:
 * Could you solve it using only O(1) extra space?
 *
 * Example 1:
 * Input:
 * ["a","a","b","b","c","c","c"]
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 *
 * Example 2:
 * Input:
 * ["a"]
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * Explanation:
 * Nothing is replaced.
 *
 * Example 3:
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 *
 * Note:
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 */

public class StringCompression_443 {

    public static void main(String[] args) {
        char[] list = new char[]{'a','b','c','c'};
        int a = compress(list);
        for (int i = 0; i < a; i++) {
            System.out.println(list[i]);
        }
    }

    public static int compress(char[] chars) {
        int len = chars.length;
        if (len == 1) {
            return 1;
        }
        int answer = 0;
        int pointer = 0;
        int repeatNum = 1;
        String strRepeatNum;
        char lastLetter = ' ';
        for (int i = 0; i < len - 1; i++) {
            if (chars[i+1] == chars[i]) {
                lastLetter = chars[i];
                repeatNum++;
            } else {
                lastLetter = chars[i];
                strRepeatNum = String.valueOf(repeatNum);
                chars[pointer] = chars[i];
                answer++;
                pointer++;
                if (repeatNum != 1){
                    for (int j = 0; j < strRepeatNum.length(); j++) {
                        chars[pointer] = strRepeatNum.charAt(j);
                        pointer++;
                        answer++;
                    }
                }
                repeatNum = 1;
            }
        }
        // 为避免出错，数组的最后一个元素单独判断
        if (chars[len-1] == lastLetter){
            strRepeatNum = String.valueOf(repeatNum);
            chars[pointer] = lastLetter;
            answer++;
            pointer++;
            if (repeatNum != 1){
                for (int j = 0; j < strRepeatNum.length(); j++) {
                    chars[pointer] = strRepeatNum.charAt(j);
                    pointer++;
                    answer++;
                }
            }
        } else {
            chars[pointer] = chars[len-1];
            answer++;
        }
        return answer;
    }
    /**
     * pass
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :38 MB, 在所有 Java 提交中击败了45.39%的用户
     */
}
