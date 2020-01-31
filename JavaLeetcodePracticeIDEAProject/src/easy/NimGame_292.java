package easy;

/**
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table,
 * each time one of you take turns to remove 1 to 3 stones.
 * The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 * Both of you are very clever and have optimal strategies for the game. Write a function
 * to determine whether you can win the game given the number of stones in the heap.
 *
 * Example:
 * Input: 4
 * Output: false
 * Explanation: If there are 4 stones in the heap, then you will never win the game;
 *              No matter 1, 2, or 3 stones you remove, the last stone will always be
 *              removed by your friend.
 */

public class NimGame_292 {

    public static void main(String[] args) {
        System.out.println(canWinNim(4));
    }

    public static boolean canWinNim(int n) {
        /**
         * 一个找规律的题：当我拿完还剩1、2、3个时，必败，
         * 故我拿前有4个时必败，所以只要在我拿前有5、6、7个时，就可以必胜（5个时拿走一个，6拿2，7拿3，使对手转入拿前4个的必败状态），
         * 所以我拿前还有8个时必败（使对手转入必胜的拿前5、6、7状态）... ...
         * Therefore，当给定数目为4的倍数时必败。
         */
        return n%4!=0;
    }
    /**
     * pass
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 32.9 MB , 在所有 Java 提交中击败了 68.40%的用户
     */
}
