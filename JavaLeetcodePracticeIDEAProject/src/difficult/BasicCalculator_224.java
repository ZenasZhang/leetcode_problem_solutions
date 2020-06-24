package difficult;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
 * non-negative integers and empty spaces .
 *
 * Example 1:
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */

public class BasicCalculator_224 {

    public static void main(String[] args) {
        System.out.println(calculate2("  (2  +3 )-(4- 5)"));
    }

    public static int calculate(String s) {
        LinkedList<Integer> indexOfBrackets = new LinkedList<>();
        s = s.replaceAll(" ", "");
        StringBuilder str = new StringBuilder(s);
        StringBuilder simpleExp = new StringBuilder();
        int indexOfLeftBracket;
        String sum = "";
        String filler = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 40) indexOfBrackets.add(i);
            if (s.charAt(i) == 41) {
                indexOfLeftBracket = indexOfBrackets.pollLast();
                str.setCharAt(i,' ');
                str.setCharAt(indexOfLeftBracket,' ');
                sum = simpleSum(str.substring(indexOfLeftBracket+1,i))+"";
                for (int j = 0; j < i - indexOfLeftBracket - sum.length() - 1; j++) filler += " ";
                str.replace(indexOfLeftBracket+1,i,sum+filler);
                filler = "";
            }
        }
        System.out.println(str.toString());
        return simpleSum(str.toString());
    }

    // to calculate expressions without brackets
    public static int simpleSum(String s) {
        int answer = 0;
        s = s.replaceAll(" ", "");
        s = s.replaceAll("--","+");
        s = s.replaceAll("-","+-");
        String[] nums = s.split("[+]");
        for (String i : nums) if (!i.equals("")) answer += Integer.parseInt(i);
        return answer;
    }
    /**
     * it is correct, but it can not satisfy time limitation
     */


    // others method
    public static int calculate2(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        // sign 代表正负
        int sign = 1, res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1)))
                    cur = cur * 10 + s.charAt(++i) - '0';
                res = res + sign * cur;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                // 将之前的结果和符号一同存进栈里
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (ch == ')') {
                // 当前结果先乘括号前的符号，再加上之前的结果
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }
}