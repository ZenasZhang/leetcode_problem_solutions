package easy;

//NO. 14
/*
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

示例 1:
输入: ["flower","flow","flight"]
输出: "fl"

示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

说明:所有输入只包含小写字母 a-z 。
 */

import java.util.ArrayList;

public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder answer = new StringBuilder();
        // 定义最短单词长度
        int wordShortestLength = 100;
        //将字符串数组中的字符串转换为StringBuilder,存入ArrayList中
        ArrayList<StringBuilder> strBuilders = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < wordShortestLength) {
                // 获取最短单词长度
                wordShortestLength = strs[i].length();
            }
            if (i > 0) {
                strBuilders.add(new StringBuilder(strs[i]));
            }
        }
        int sameLetterNum = 0;
        // 将第一个单词变为char数组
        char[] charsOfFirstWord = strs[0].toCharArray();
        outerLoop:
        for (int i = 0; i < wordShortestLength; i++) {
            // 检测其他单词对应位置的字母
            for (StringBuilder s : strBuilders) {
                if (charsOfFirstWord[i] == s.charAt(i)) {
                    sameLetterNum++;
                } else {
                    break outerLoop;
                }
            }
            if (sameLetterNum == strBuilders.size()) {
                answer.append(charsOfFirstWord[i]);
            }
            sameLetterNum = 0;
        }
        return answer.toString();
    }
}
