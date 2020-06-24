package medium;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * Example:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * <p>
 * Constraints:
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */

public class WordSearch_79 {
    static class Point{
        int x;
        int y;
        public Point(){}
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }


    public static boolean exist(char[][] board, String word) {
        int height = board.length;
        int length = board[0].length;
        if (length == 1) {

        }
        if (height == 1) {

        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] == word.charAt(0)) {
                    Point point = new Point();
                    //store all branches to recall if needed
                    ArrayList<ArrayList<Point>> allBranch = new ArrayList<>();
                    for (int k = 1; k < word.length(); k++) {
                        if (j == 0) {
                            if (i == 0) {
                                if (board[i + 1][j] == word.charAt(k)) {
                                    // one branch that stores all coordinates
                                    ArrayList<Point> coordinatesChosen = new ArrayList<>();
                                    coordinatesChosen.add(new Point(i,j));
                                    point.x = i + 1;
                                    point.y = j;
                                    if (!coordinatesChosen.contains(point)) {
                                        coordinatesChosen.add(new Point(i + 1, j));
                                    }
                                }
                            }
                            if (i == length - 1) {

                            }
                        }
                    }
                }
            }
        }
        return false;
    }

}
