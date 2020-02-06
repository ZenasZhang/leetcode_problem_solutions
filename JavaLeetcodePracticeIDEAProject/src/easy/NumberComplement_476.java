package easy;

/**
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 * <p>
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010.
 * So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */

public class NumberComplement_476 {

    public static void main(String[] args) {
        System.out.println(2>>1);
        System.out.println(findComplement(1));
    }

    public static int findComplement(int num) {
        String binary = "";
        int answer = 0;
        while (num > 0) {
            int modNum = num - (num / 2) * 2;
            binary = binary + modNum;
            num /= 2;
        }
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == 48) answer += Math.pow(2, i);
        }
        return answer;
    }
    /**
     * pass
     * 执行用时 :2 ms, 在所有 Java 提交中击败了10.14%的用户
     * 内存消耗 :33.5 MB, 在所有 Java 提交中击败了5.24%的用户
     */


    // 使用位运算
//    位运算的知识。 思路：求num的二进制表示数，比如10->1010，然后按位取反->0101。转换成十进制->5
//
//    重点1.边求二进制位取反，边构建十进制数。如何获取二进制的最后一位：num & 1 即表示二进制的最后一位，&操作，同1则1。这里不明白的动手写一个例子，加深理解。
//    重点2.取反构建十进制，如果(num & 1) == 1，取反就要为0。那么如何构建10进制呢？使用一个变量，记录当前的位->个、十、百...位。使用左移位，来扩大当前位数对应的倍数。
    public static int findComplement2(int num) {
        int res = 0;
        int b = 0;
        for (; num != 0; num = num >> 1) {
            if ((num & 1) == 1)
                res += 0;
            if ((num & 1) == 0)
                res += 1 << b;
            b++;
        }
        return res;
    }
}
