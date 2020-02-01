package easy;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines;
 * otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */

public class RansomNote_383 {

    public static void main(String[] args) {
        System.out.println(canConstruct2("aabyyyy", "basufhviusufaaabibbbvdsbiyyyyfvhbif"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder magazineStringBuilder = new StringBuilder(magazine);
        int index;
        for (int i = 0; i < ransomNote.length(); i++) {
            index = magazineStringBuilder.indexOf(ransomNote.substring(i,i+1));
            if (index == -1) return false;
            magazineStringBuilder.deleteCharAt(index);
        }
        return true;
    }
    /**
     * pass
     * 执行用时 :6 ms, 在所有 Java 提交中击败了57.77%的用户
     * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了44.55%的用户
     */

    // use ASCII
    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] charSequence = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            charSequence[magazine.charAt(i)-97]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            charSequence[ransomNote.charAt(i)-97]--;
        }
        for (int i = 0; i < 26; i++) {
            if (charSequence[i] < 0) return false;
        }
        return true;
    }
    /**
     * pass
     * 执行用时 :5 ms, 在所有 Java 提交中击败了76.16%的用户
     * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了97.70%的用户
     */
}
