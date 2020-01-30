package easy;

import java.util.ArrayList;

/**
 * Given a string which consists of lowercase or uppercase letters,
 * find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 * Input:
 * "abccccdd"
 * Output:
 * 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

public class LongestPalindrome_409 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        int answer = 0;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                list.remove((Character) s.charAt(i));
                answer = answer + 2;
            } else {
                list.add(s.charAt(i));
            }
        }
        if (list.size() != 0) {
            answer++;
        }
        return answer;
    }
    /**
     * pass
     * 执行用时 :8 ms, 在所有 Java 提交中击败了34.87%的用户
     * 内存消耗 :34.5 MB, 在所有 Java 提交中击败了98.49%的用户
     */

    //
    public static int longestPalindrome2(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }
}
