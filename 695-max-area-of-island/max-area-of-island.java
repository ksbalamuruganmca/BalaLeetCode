class Solution {
    int temp;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    temp = 0;
                    dfs(grid, i, j, row, column);
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans;
    }

    void dfs(int[][] grid, int i, int j, int r, int c) {

        if (i < 0 || j < 0 || i >= r || j >= c || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        temp++;
        dfs(grid, i, j + 1, r, c);
        dfs(grid, i - 1, j, r, c);
        dfs(grid, i, j - 1, r, c);
        dfs(grid, i + 1, j, r, c);
    }
}