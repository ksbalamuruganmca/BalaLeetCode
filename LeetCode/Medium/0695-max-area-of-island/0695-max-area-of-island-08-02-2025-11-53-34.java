class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int column = grid[0].length;
        int ansArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    int calArea = dfs(grid, i, j, row, column);
                    ansArea = Math.max(calArea, ansArea);
                }
            }
        }
        return ansArea;
    }

    int dfs(int[][] grid, int i, int j, int r, int c) {
        
        if (i < 0 || j < 0 || i >= r || j >= c || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        area += dfs(grid, i, j + 1, r, c);
        area += dfs(grid, i - 1, j, r, c);
        area += dfs(grid, i, j - 1, r, c);
        area += dfs(grid, i + 1, j, r, c);
        return area;
    }
}