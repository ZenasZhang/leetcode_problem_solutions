package easy;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 */

public class IsomorphicStrings_205 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic2("ab","nc"));
    }

    // method 1: use Map
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (t.charAt(i) != map.get(s.charAt(i))) return false;
            } else {
                if (map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
    /**
     * pass
     * 执行用时 :16 ms, 在所有 Java 提交中击败了37.46%的用户
     * 内存消耗 :36.4 MB, 在所有 Java 提交中击败了96.04%的用户
     */

    // method 2: use number to represent patterns (ASCII)
    public static boolean isIsomorphic2(String s, String t) {
        int[] likeMap1 = new int[128];
        int count = 1;
        StringBuilder pattern1 = new StringBuilder();
        StringBuilder pattern2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (likeMap1[s.charAt(i)] == 0) {
                likeMap1[s.charAt(i)] = count;
                pattern1.append(count);
                count++;
            } else {
                pattern1.append(likeMap1[s.charAt(i)]);
            }
        }
        count = 1;
        int[] likeMap2 = new int[128];
        for (int i = 0; i < t.length(); i++) {
            if (likeMap2[t.charAt(i)] == 0) {
                likeMap2[t.charAt(i)] = count;
                pattern2.append(count);
                count++;
            } else {
                pattern2.append(likeMap2[t.charAt(i)]);
            }
        }
        return pattern1.toString().equals(pattern2.toString());
    }
    /**
     * pass
     * 执行用时 :9 ms, 在所有 Java 提交中击败了67.50%的用户
     * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了97.24%的用户
     */
}
