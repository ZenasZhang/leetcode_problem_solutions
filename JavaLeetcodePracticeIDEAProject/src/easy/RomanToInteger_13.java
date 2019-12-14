package easy;

//NO. 13
/*
罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

示例 1:

输入: "III"
输出: 3
示例 2:

输入: "IV"
输出: 4
示例 3:

输入: "IX"
输出: 9
示例 4:

输入: "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.
示例 5:

输入: "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */

import java.util.HashMap;

public class RomanToInteger_13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int answer = 0;
        // 创建哈希表，将所有内容储存
        HashMap<String, Integer> roman_int = new HashMap<>();
        roman_int.put("I",1);
        roman_int.put("V",5);
        roman_int.put("X",10);
        roman_int.put("L",50);
        roman_int.put("C",100);
        roman_int.put("D",500);
        roman_int.put("M",1000);
        roman_int.put("IV",4);
        roman_int.put("IX",9);
        roman_int.put("XL",40);
        roman_int.put("XC",90);
        roman_int.put("CD",400);
        roman_int.put("CM",900);
        //创建对应的哈希表的键的集合
        String[] key = new String[]{"I", "V", "X", "L", "C", "D", "M", "IV", "IX", "XL", "XC", "CD", "CM"};
        //将罗马数字字符串转换为StringBulider加快速度
        StringBuilder roman = new StringBuilder(s);
        for (int i = 0; i < 6; i++) {
            // 判断罗马数字内有没有"IV", "IX", "XL", "XC", "CD", "CM"组合
            int indexOfDoubleRoman = roman.indexOf(key[i+7]);
            if(indexOfDoubleRoman > -1){
                //若有则将答案加上对应的数字，并删除给出的罗马数中相应的组合
                answer += roman_int.get(key[i+7]);
                roman.delete(indexOfDoubleRoman,indexOfDoubleRoman+2);
            }
        }
        // 检查并删除完组合后就剩下单一的罗马数
        for (int i = 0; i < roman.length(); i++) {
            answer += roman_int.get(roman.substring(i,i+1));
        }
        return answer;
    }
}
