package easy;
/*
题目的意思是对序列前一个数进行报数，数列第一项不是1吗，那第二项就报第一项的有1个1，输出11，然后第三项就在第二项的基础上报数，
第二项是11，第三项不就是2个1么，然后输出21。。。
报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
注意：整数顺序将表示为一个字符串。

示例 1:
输入: 1
输出: "1"
示例 2:
输入: 4
输出: "1211"
 */
public class CountAndSay_38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }

    public static String countAndSay(int n) {
        if (n<0 || n>30) return null;
        if(n == 1) return "1";
        StringBuilder answer = new StringBuilder("");
        // 递归，寻找之前一个是怎么say的
        StringBuilder preSay = new StringBuilder(countAndSay(n-1)).append(" "); //踩坑，要是不加一个尾巴让它和前面的一定不一样
        String number = "";                                                        // 就会删不掉前面的
        while (preSay.length() != 1) {
            int count = 0;
            for (int i = 0; i < preSay.length(); i++) {
                if(preSay.charAt(0) == preSay.charAt(i)){
                    count++;
                }else {
                    answer.append(count).append(preSay.charAt(0));
                    preSay.delete(0,i);
                    break;
                }
            }
        }
        return answer.toString();
    }
}
