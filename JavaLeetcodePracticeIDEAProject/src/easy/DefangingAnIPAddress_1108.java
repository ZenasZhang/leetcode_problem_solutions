package easy;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 *
 * Example 1:
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 * Constraints:
 * The given address is a valid IPv4 address.
 */

public class DefangingAnIPAddress_1108 {

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }

    public static String defangIPaddr(String address) {
        // the escape character of "." is \u002E
        String[] numList = address.split("\\u002E");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numList.length; i++) {
            if (i > 0) {
                answer.append("[\u002E]").append(numList[i]);
            } else {
                answer.append(numList[i]);
            }
        }
        return answer.toString();
    }
    /**
     * pass
     * 执行用时 :3 ms, 在所有 java 提交中击败了49.82%的用户
     * 内存消耗 :34.4 MB, 在所有 java 提交中击败了100.00%的用户
     */
}
