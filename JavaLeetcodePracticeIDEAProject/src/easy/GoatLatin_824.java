package easy;

/**
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * The rules of Goat Latin are as follows:
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin. 
 *
 * Example 1:
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *  
 * Notes:
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 */

public class GoatLatin_824 {

    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));

    }

    public static String toGoatLatin(String S) {
        StringBuilder answer = new StringBuilder();
        int index = 1;
        for (String i : S.split(" ")) {
            char l = i.charAt(0);
            if (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u' || l == 'A' || l == 'E' || l == 'I' || l == 'O' || l == 'U') {
                answer.append(i).append("ma");
                for (int j = 0; j < index; j++) answer.append('a');
                answer.append(' ');
                index++;
            } else {
                answer.append(i.substring(1)).append(l).append("ma");
                for (int j = 0; j < index; j++) answer.append('a');
                answer.append(' ');
                index++;
            }
        }
        answer.deleteCharAt(answer.length()-1);
        return answer.toString();
    }
    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 95.87% 的用户
     * 内存消耗 : 34.6 MB , 在所有 Java 提交中击败了 96.84% 的用户
     */
}
