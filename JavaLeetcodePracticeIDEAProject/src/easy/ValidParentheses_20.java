package easy;

// NO.20
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:
输入: "()"
输出: true
示例 2:
输入: "()[]{}"
输出: true
示例 3:
输入: "(]"
输出: false
示例 4:
输入: "([)]"
输出: false
示例 5:
输入: "{[]}"
输出: true

{ open brace,open curly 左花括号
} close brace,close curly 右花括号
( open parenthesis,open paren 左圆括号
) close parenthesis,close paren 右圆括号
() brackets/ parentheses 括号
[ open bracket 左方括号
] close bracket 右方括号
[] square brackets 方括号
 */

import java.util.HashMap;
import java.util.LinkedList;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        System.out.println(isValid("([][][][][][][][][[[[]][[)"));
    }

    public static boolean isValid(String s) {
//        // 空返回true
//        if(s.length() == 0 || s.equals("{}") || s.equals("()") || s.equals("[]")) return true;
//        // 长度为奇数,首位为闭括号，末尾为开括号必错
//        int length = s.length();
//        if(s.length() % 2 == 1 || s.charAt(0) == '}' || s.charAt(0) == ']' || s.charAt(0) == ')'
//                || s.charAt(length - 1) == '{' || s.charAt(length - 1) == '[' || s.charAt(length - 1) == '('){
//            return false;
//        }
//
//        String openBrace = "{";
//        String closeBrace = "}";
//        String openBracket = "[";
//        String closeBracket = "]";
//        String openParenthesis = "(";
//        String closeParenthesis = ")";
//
//        StringBuilder str = new  StringBuilder(s);
//
//        int indexOfopenBrace = str.indexOf(openBrace);
//        int indexOfcloseBrace = str.indexOf(closeBrace);
//        int indexOfopenBracket = str.indexOf(openBracket);
//        int indexOfcloseBracket = str.indexOf(closeBracket);
//        int indexOfopenParenthesis = str.indexOf(openParenthesis);
//        int indexOfcloseParenthesis = str.indexOf(closeParenthesis);
//
//        if((indexOfcloseBrace == -1 && indexOfopenBrace > -1) ||
//                (indexOfcloseBrace > -1 && indexOfopenBrace == -1) ||
//                (indexOfcloseBracket == -1 && indexOfopenBracket > -1) ||
//                (indexOfcloseBracket > -1 && indexOfopenBracket == -1) ||
//                (indexOfcloseParenthesis == -1 && indexOfopenParenthesis > -1) ||
//                (indexOfcloseParenthesis > -1 && indexOfopenParenthesis == -1) ){
//            return false;
//        }
//
//        // 依次检测三种括号内部的括号数量
//        // 猜想：第一次出现的开括号和同种最后一次出现的闭括号index之差应该小于0
//        //      且他们之间的括号数只能是偶数（index相减为奇数）
//        boolean b1,b2,b3;
//        if(indexOfcloseParenthesis > -1 && indexOfopenParenthesis > -1){
//            b1 = (str.lastIndexOf(closeParenthesis) - str.indexOf(openParenthesis)) % 2 == 1;
//        }else {
//            b1 = true;
//        }
//        if(indexOfcloseBrace > -1 && indexOfopenBrace > -1){
//            b2 = (str.lastIndexOf(closeBrace) - str.indexOf(openBrace)) % 2 == 1;
//        }else {
//            b2 = true;
//        }
//        if(indexOfcloseBracket > -1 && indexOfopenBracket > -1){
//            b3 = (str.lastIndexOf(closeBracket) - str.indexOf(openBracket)) % 2 == 1;
//        }else {
//            b3 = true;
//        }
//        return b1 && b2 && b3;
        // 失败


        // 官方解题：用栈的思想，每次出现开括号，压入栈，有闭括号时和栈顶的相比较，如果匹配就将顶端弹出，如果不匹配直接判错
        if (s.length() == 0) return true;
        if (s.length() % 2 == 1 || s.charAt(0) == '}' || s.charAt(0) == ']' || s.charAt(0) == ')') {
            return false;
        }
        HashMap<Character,Character> charPairs = new HashMap<>();
        charPairs.put('}','{');
        charPairs.put(']','[');
        charPairs.put(')','(');
        LinkedList<Character> chars = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
                chars.push(s.charAt(i));
            } else {
                if (chars.peek() == charPairs.get(s.charAt(i))) {
                    chars.pop();
                }else{
                    return false;
                }
            }
        }
        if (chars.size() == 0) {
            return true;
        }else {
            return false;
        }
    }
}
