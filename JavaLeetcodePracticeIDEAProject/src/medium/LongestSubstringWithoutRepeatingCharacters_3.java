package medium;

//NO. 3
/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        StringBuilder str = new StringBuilder(s);
        int answer = 0;
        int findNumber = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length() + 1; j++) {
                if (j == str.length()) {
                    findNumber++;
                    break;
                }
                // 如果下一个字母不在当前字串里，answer + 1
                if(str.substring(i,j).indexOf(String.valueOf(str.charAt(j))) == -1){
                    findNumber++;
                } else {
                    findNumber++;
                    break;
                }
            }
            if (findNumber > answer) {
                answer = findNumber;
            }
            if (answer > str.length() - i) {
                break;
            }
            findNumber=0;
        }
        return answer; // 通过，但耗时太长
    }
}
/*
官方解题
滑动窗口
算法

暴力法非常简单，但它太慢了。那么我们该如何优化它呢？

在暴力法中，我们会反复检查一个子字符串是否含有有重复的字符，但这是没有必要的。如果从索引 ii 到 j - 1j−1 之间的子字符串 s_{ij}s
ij
​
  已经被检查为没有重复字符。我们只需要检查 s[j]s[j] 对应的字符是否已经存在于子字符串 s_{ij}s
ij
​
  中。

要检查一个字符是否已经在子字符串中，我们可以检查整个子字符串，这将产生一个复杂度为 O(n^2)O(n
2
 ) 的算法，但我们可以做得更好。

通过使用 HashSet 作为滑动窗口，我们可以用 O(1)O(1) 的时间来完成对字符是否在当前的子字符串中的检查。

滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i, j)[i,j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j)[i,j) 向右滑动 11 个元素，则它将变为 [i+1, j+1)[i+1,j+1)（左闭，右开）。

回到我们的问题，我们使用 HashSet 将字符存储在当前窗口 [i, j)[i,j)（最初 j = ij=i）中。 然后我们向右侧滑动索引 jj，如果它不在 HashSet 中，我们会继续滑动 jj。直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 ii 开头。如果我们对所有的 ii 这样做，就可以得到答案。

Java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
复杂度分析

时间复杂度：O(2n) = O(n)O(2n)=O(n)，在最糟糕的情况下，每个字符将被 ii 和 jj 访问两次。

空间复杂度：O(min(m, n))O(min(m,n))，与之前的方法相同。滑动窗口法需要 O(k)O(k) 的空间，其中 kk 表示 Set 的大小。而 Set 的大小取决于字符串 nn 的大小以及字符集 / 字母 mm 的大小。

方法三：优化的滑动窗口
上述的方法最多需要执行 2n 个步骤。事实上，它可以被进一步优化为仅需要 n 个步骤。我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。

也就是说，如果 s[j] 在 [i, j) 范围内有与 j'重复的字符，我们不需要逐渐增加 i 。 我们可以直接跳过 [i，j']范围内的所有元素，并将 i 变为 j' + 1。

Java（使用 HashMap）
Java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
Java（假设字符集为 ASCII 128）
以前的我们都没有对字符串 s 所使用的字符集进行假设。
当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。
常用的表如下所示：
int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
int [128] 用于ASCII码
int [256] 用于扩展ASCII码

Java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
复杂度分析
时间复杂度：O(n)O(n)，索引 jj 将会迭代 nn 次。
空间复杂度（HashMap）：O(min(m, n))O(min(m,n))，与之前的方法相同。
空间复杂度（Table）：O(m)O(m)，mm 是字符集的大小。
 */
