package easy;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * Input: "race a car"
 * Output: false
 */

public class ValidPalindrome_125 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("a________xcddcba"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (isNumberOrLowLetter(leftChar) && isNumberOrLowLetter(rightChar)) {
                if (leftChar != rightChar) {
                    return false;
                } else {
                    right--;
                    left++;
                }
            } else if (isNumberOrLowLetter(leftChar) && !isNumberOrLowLetter(rightChar)) {
                right--;
            } else if (!isNumberOrLowLetter(leftChar) && isNumberOrLowLetter(rightChar)) {
                left++;
            } else {
                right--;
                left++;
            }
        }
        return true;
    }

    public static boolean isNumberOrLowLetter(char c) {
        if (((((int) c) > 96 && ((int) c) < 123) || (((int) c) > 47 && ((int) c) < 58))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * pass
     * 执行用时 :6 ms, 在所有 java 提交中击败了61.33%的用户
     * 内存消耗 :37.7 MB, 在所有 java 提交中击败了89.73%的用户
     */
}
