package easy;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 * 1. The length of both num1 and num2 is < 5100.
 * 2. Both num1 and num2 contains only digits 0-9.
 * 3. Both num1 and num2 does not contain any leading zero.
 * 4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class AddStrings_415 {

    public static void main(String[] args) {
        System.out.println(addStrings("1","9"));
    }

    public static String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int carryNum = 0;
        StringBuilder answer = new StringBuilder();
        if (len1 > len2) {
            for (int i = len1 - 1; i > -1; i--) {
                int currentDigit;
                if (i >= len1 - len2) {
                    currentDigit = (int) num1.charAt(i) + (int) num2.charAt(i - len1 + len2) + carryNum - 96;
                    if (currentDigit > 9) {
                        answer.append(currentDigit % 10);
                        carryNum = currentDigit / 10;
                    } else {
                        answer.append(currentDigit);
                        carryNum = 0;
                    }
                } else {
                    currentDigit = (int) num1.charAt(i) + carryNum - 48;
                    if (currentDigit > 9) {
                        answer.append(currentDigit % 10);
                        carryNum = currentDigit / 10;
                    } else {
                        answer.append(currentDigit);
                        carryNum = 0;
                    }
                }
            }
            if (carryNum != 0) {
                answer.append(carryNum);
            }
        } else {
            for (int i = len2 - 1; i > -1; i--) {
                int currentDigit;
                if (i >= len2 - len1) {
                    currentDigit = (int) num2.charAt(i) + (int) num1.charAt(i - len2 + len1) + carryNum - 96;
                    if (currentDigit > 9) {
                        answer.append(currentDigit % 10);
                        carryNum = currentDigit / 10;
                    } else {
                        answer.append(currentDigit);
                        carryNum = 0;
                    }
                } else {
                    currentDigit = (int) num2.charAt(i) + carryNum - 48;
                    if (currentDigit > 9) {
                        answer.append(currentDigit % 10);
                        carryNum = currentDigit / 10;
                    } else {
                        answer.append(currentDigit);
                        carryNum = 0;
                    }
                }
            }
            if (carryNum != 0) {
                answer.append(carryNum);
            }
        }
        return answer.reverse().toString();
    }
    /**
     * pass
     * 执行用时 :2 ms, 在所有 Java 提交中击败了99.03%的用户
     * 内存消耗 :36.1 MB, 在所有 Java 提交中击败了64.15%的用户
     */
}
