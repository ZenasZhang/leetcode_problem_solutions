package easy;

import java.util.Arrays;

/**
 * For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area,
 * your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:
 * 1. The area of the rectangular web page you designed must equal to the given target area.
 * 2. The width W should not be larger than the length L, which means L >= W.
 * 3. The difference between length L and width W should be as small as possible.
 * You need to output the length L and the width W of the web page you designed in sequence.
 * <p>
 * Example:
 * Input: 4
 * Output: [2, 2]
 * Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
 * But according to requirement 2, [1,4] is illegal; according to requirement 3,
 * [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
 * <p>
 * Note:
 * The given area won't exceed 10,000,000 and is a positive integer
 * The web page's width and length you designed must be positive integers.
 */

public class ConstructTheRectangle_492 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructRectangle(4)));
    }

    public static int[] constructRectangle(int area) {
        int d = 0;
        // 中心拓展法
        for (int i =(int) Math.floor(Math.sqrt(area)) ; i > 0; i--) {
            if (area % i == 0) {
                d = i;
                break;
            }
        }
        return new int[]{area / d, d};
    }
    /**
     * pass
     * 执行用时 :1 ms, 在所有 Java 提交中击败了96.77%的用户
     * 内存消耗 :33.4 MB, 在所有 Java 提交中击败了87.37%的用户
     */
}
