package easy;

/**
 * Your friend is typing his name into a keyboard.
 * Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 * You examine the typed characters of the keyboard.
 * Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 *
 * Example 1:
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 *
 * Example 2:
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 *
 * Example 3:
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 *
 * Example 4:
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 *
 * Constraints:
 *     1 <= name.length <= 1000
 *     1 <= typed.length <= 1000
 *     The characters of name and typed are lowercase letters.
 */

public class LongPressedName_925 {

    public static void main(String[] args) {
        System.out.println(isLongPressedName("pyplrz","ppyypllrz"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        char[] nameArray = name.toCharArray();
        char[] typedArray = typed.toCharArray();
        int nameRepeatTimes = 1, typedRepeatTimes = 1, typedIndex = 0;
        for (int i = 0; i < name.length(); i++) {
            if (i > 0) {
                if (nameArray[i - 1] == nameArray[i]) {
                    nameRepeatTimes++;
                    if (typedRepeatTimes >= nameRepeatTimes) {
                        continue;
                    } else return false;

                } else nameRepeatTimes = 1;
            }
            if (typedIndex < typed.length()) {
                if (typedArray[typedIndex] == nameArray[i]) {
                    typedIndex++;
                    typedRepeatTimes = 1;
                    while (true) {
                        if (typedIndex > typed.length() - 1) {
                            break;
                        }
                        if (typedArray[typedIndex] == nameArray[i]) {
                            typedIndex++;
                            typedRepeatTimes++;
                        }else {
                            break;
                        }
                    }
                } else {
                    return false;
                }
            } else return false;
        }
        // typedIndex != typed.length() means that typed has more chars that are not appearing in name
        if (typedIndex != typed.length()) return false;
        return true;
    }
}
/**
 * pass
 * 执行用时：1 ms, 在所有 Java 提交中击败了87.13% 的用户
 * 内存消耗：37.7 MB, 在所有 Java 提交中击败了20.00% 的用户
 */
