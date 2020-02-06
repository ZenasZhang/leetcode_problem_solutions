package easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
 * "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example,
 * "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 * Return the number of different transformations among all words we have.
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * There are 2 different transformations, "--...-." and "--...--.".
 * Note:
 * The length of words will be at most 100.
 * Each words[i] will have length in range [1, 12].
 * words[i] will only consist of lowercase letters.
 */

public class UniqueMorseCodeWords_804 {

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        HashMap<Character,String> morseCode = new HashMap<>();
        morseCode.put('a',".-");
        morseCode.put('b',"-...");
        morseCode.put('c',"-.-.");
        morseCode.put('d',"-..");
        morseCode.put('e',".");
        morseCode.put('f',"..-.");
        morseCode.put('g',"--.");
        morseCode.put('h',"....");
        morseCode.put('i',"..");
        morseCode.put('j',".---");
        morseCode.put('k',"-.-");
        morseCode.put('l',".-..");
        morseCode.put('m',"--");
        morseCode.put('n',"-.");
        morseCode.put('o',"---");
        morseCode.put('p',".--.");
        morseCode.put('q',"--.-");
        morseCode.put('r',".-.");
        morseCode.put('s',"...");
        morseCode.put('t',"-");
        morseCode.put('u',"..-");
        morseCode.put('v',"...-");
        morseCode.put('w',".--");
        morseCode.put('x',"-..-");
        morseCode.put('y',"-.--");
        morseCode.put('z',"--..");
        HashSet<String> uniqueCode = new HashSet<>();
        for (String i : words) {
            StringBuilder code = new StringBuilder();
            for (int j = 0; j < i.length(); j++) {
                code.append(morseCode.get(i.charAt(j)));
            }
            uniqueCode.add(code.toString());
        }
        return uniqueCode.size();
    }
    /**
     * pass
     * 执行用时 :3 ms, 在所有 Java 提交中击败了59.04%的用户
     * 内存消耗 :35.5 MB, 在所有 Java 提交中击败了71.22%的用户
     */
}
