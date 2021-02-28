package leetcodetop.bytedance;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int area;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    area = area(grid, i, j);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    public int area(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        grid[row][col] = 0;
        int up = 0, down = 0, left = 0, right = 0;
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            up = area(grid, row - 1, col);
        }
        if (row + 1 < rows && grid[row + 1][col] == 1) {
            down = area(grid, row + 1, col);
        }
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            left = area(grid, row, col - 1);
        }
        if (col + 1 < cols && grid[row][col + 1] == 1) {
            right = area(grid, row, col + 1);
        }
        return 1 + up + down + left + right;
    }
}
