package easy;

import javax.annotation.Generated;

/**
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */

public class AddBinary_67 {

    public static void main(String[] args) {
        System.out.println(addBinary("1111","1111"));
    }

    public static String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA > lenB) {
            int diff = lenA - lenB;
            for (int i = 0; i < diff; i++) {
                b = "0" + b;
            }
        } else if (lenA < lenB) {
            int diff = lenB - lenA;
            for (int i = 0; i < diff; i++) {
                a = "0" + a;
            }
        }
        int carry = 0;
        int len = a.length();
        StringBuilder answer = new StringBuilder();
        for (int i = len - 1; i > -1; i--) {
            // 新发现： char直接 -'0' 就可以进行运算而且不是ascii码
            int curSum = (a.charAt(i)-'0') + (b.charAt(i)-'0');
            if (curSum + carry == 2) {
                answer.append(0);
                carry = 1;
            } else if (curSum + carry == 3) {
                answer.append(1);
                carry = 1;
            } else {
                answer.append(curSum + carry);
                carry = 0;
            }
        }
        if (carry == 1) {
            answer.append(1);
            return answer.reverse().toString();
        }
        return answer.reverse().toString();
    }
    /**
     * pass
     * 执行用时 :3 ms, 在所有 java 提交中击败了71.46%
     * 的用户
     * 内存消耗 :36.1 MB, 在所有 java 提交中击败了55.25%的用户
     */

    //optimize
    public static String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
