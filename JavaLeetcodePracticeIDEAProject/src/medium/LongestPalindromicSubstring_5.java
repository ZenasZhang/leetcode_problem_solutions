package medium;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * Link：https://leetcode-cn.com/problems/longest-palindromic-substring
 */

public class LongestPalindromicSubstring_5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc"));
    }

    public static String longestPalindrome(String s) {
        int longestLen = 0;
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                if (isPalindrome(s.substring(i, j))) {
                    if (j - i > longestLen) {
                        longestLen = j - i;
                        answer = s.substring(i, j);
                    }
                }
            }
        }
        return answer;
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar != rightChar) {
                return false;
            } else {
                right--;
                left++;
            }
        }
        return true;
    }
    // can not pass because of time limitation



    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }


    /**
     * 方法四：中心扩展算法
     * 事实上，只需使用恒定的空间，我们就可以在 O(n^2)O(n
     * 2
     *  ) 的时间内解决这个问题。
     *
     * 我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 12n−1 个这样的中心。
     *
     * 你可能会问，为什么会是 2n - 12n−1 个，而不是 nn 个中心？原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 \textrm{“abba”}“abba” 的中心在两个 \textrm{‘b’}‘b’ 之间）。
     *
     * Java
     * public String longestPalindrome(String s) {
     *     if (s == null || s.length() < 1) return "";
     *     int start = 0, end = 0;
     *     for (int i = 0; i < s.length(); i++) {
     *         int len1 = expandAroundCenter(s, i, i);
     *         int len2 = expandAroundCenter(s, i, i + 1);
     *         int len = Math.max(len1, len2);
     *         if (len > end - start) {
     *             start = i - (len - 1) / 2;
     *             end = i + len / 2;
     *         }
     *     }
     *     return s.substring(start, end + 1);
     * }
     *
     * private int expandAroundCenter(String s, int left, int right) {
     *     int L = left, R = right;
     *     while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
     *         L--;
     *         R++;
     *     }
     *     return R - L - 1;
     * }
     * 复杂度分析
     *
     * 时间复杂度：O(n^2)O(n
     * 2
     *  )，由于围绕中心来扩展回文会耗去 O(n)O(n) 的时间，所以总的复杂度为 O(n^2)O(n^2)。
     * 空间复杂度：O(1)O(1)。
     */

}
