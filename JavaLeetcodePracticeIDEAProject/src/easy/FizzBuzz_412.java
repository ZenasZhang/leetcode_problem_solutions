package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 * <p>
 * Example:
 * n = 15,
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */

public class FizzBuzz_412 {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 3 == 0) {
                if ((i + 1) % 5 == 0) answer.add("FizzBuzz");
                else answer.add("Fizz");
                continue;
            }
            if ((i + 1) % 5 == 0) {
                answer.add("Buzz");
                continue;
            }
            answer.add(String.valueOf(i + 1));
        }
        return answer;
    }
    /**
     * pass
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了51.25%的用户
     */
}
