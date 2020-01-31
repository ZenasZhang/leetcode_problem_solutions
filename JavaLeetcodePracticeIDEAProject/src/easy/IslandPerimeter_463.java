package easy;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 * Example:
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * https://assets.leetcode.com/uploads/2018/10/12/island.png
 */

public class IslandPerimeter_463 {

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }

    public static int islandPerimeter(int[][] grid) {
        int answer = 0;
        // 获取行列长度
        int rowLength = grid.length;
        int colLength = grid[0].length;
        if (rowLength == 1) {
            int num1 = 0;
            for (int i = 0; i < colLength; i++) {
                if (grid[0][i] == 1) {
                    num1++;
                }
            }
            return num1*2+2;
        }
        if (colLength == 1) {
            int num1 = 0;
            for (int i = 0; i < rowLength; i++) {
                if (grid[i][0] == 1) {
                    num1++;
                }
            }
            return num1*2+2;
        }
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                // 当是第一行时
                if (i == 0) {
                    if (j == 0) {
                        if (grid[i][j] == 1) {
                            answer += 4;
                            if (grid[i][j+1] == 1) {
                                answer--;
                            }
                            if (grid[i+1][j] == 1) {
                                answer--;
                            }
                        }
                        continue;
                    }
                    if (j == colLength - 1) {
                        if (grid[i][j] == 1) {
                            answer += 4;
                            if (grid[i][j-1] == 1) {
                                answer--;
                            }
                            if (grid[i+1][j] == 1) {
                                answer--;
                            }
                        }
                        continue;
                    }
                    if (grid[i][j] == 1) {
                        answer += 4;
                        if (grid[i][j+1] == 1) {
                            answer--;
                        }
                        if (grid[i+1][j] == 1) {
                            answer--;
                        }
                        if (grid[i][j-1] == 1) {
                            answer--;
                        }
                    }
                    continue;
                }
                // 当是最后一行时
                if (i == rowLength - 1) {
                    if (j == 0) {
                        if (grid[i][j] == 1) {
                            answer += 4;
                            if (grid[i][j+1] == 1) {
                                answer--;
                            }
                            if (grid[i-1][j] == 1) {
                                answer--;
                            }
                        }
                        continue;
                    }
                    if (j == colLength - 1) {
                        if (grid[i][j] == 1) {
                            answer += 4;
                            if (grid[i][j-1] == 1) {
                                answer--;
                            }
                            if (grid[i-1][j] == 1) {
                                answer--;
                            }
                        }
                        continue;
                    }
                    if (grid[i][j] == 1) {
                        answer += 4;
                        if (grid[i][j+1] == 1) {
                            answer--;
                        }
                        if (grid[i-1][j] == 1) {
                            answer--;
                        }
                        if (grid[i][j-1] == 1) {
                            answer--;
                        }
                    }
                    continue;
                }
                // 当是普通行时
                {
                    if (j == 0) {
                        if (grid[i][j] == 1) {
                            answer += 4;
                            if (grid[i][j+1] == 1) {
                                answer--;
                            }
                            if (grid[i+1][j] == 1) {
                                answer--;
                            }
                            if (grid[i-1][j] == 1) {
                                answer--;
                            }
                        }
                        continue;
                    }
                    if (j == colLength - 1) {
                        if (grid[i][j] == 1) {
                            answer += 4;
                            if (grid[i][j-1] == 1) {
                                answer--;
                            }
                            if (grid[i+1][j] == 1) {
                                answer--;
                            }
                            if (grid[i-1][j] == 1) {
                                answer--;
                            }
                        }
                        continue;
                    }
                    if (grid[i][j] == 1) {
                        answer += 4;
                        if (grid[i][j+1] == 1) {
                            answer--;
                        }
                        if (grid[i+1][j] == 1) {
                            answer--;
                        }
                        if (grid[i][j-1] == 1) {
                            answer--;
                        }
                        if (grid[i-1][j] == 1) {
                            answer--;
                        }
                    }
                }
            }
        }
        return answer;
    }
    /**
     * pass
     * 执行用时 :9 ms, 在所有 Java 提交中击败了82.81%的用户
     * 内存消耗 :59.3 MB, 在所有 Java 提交中击败了10.80%的用户
     */
}
