class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int column = image[0].length;
        int oldColor = image[sr][sc];
        if (oldColor == color)
            return image;
        dfs(image, sr, sc, row, column, oldColor, color);
        return image;
    }

    void dfs(int[][] grid, int i, int j, int r, int c, int oldColor, int color) {
        if (i < 0 || j < 0 || i >= r || j >= c || grid[i][j] != oldColor) {
            return;
        }
        grid[i][j] = color;
        dfs(grid, i, j + 1, r, c, oldColor, color);
        dfs(grid, i - 1, j, r, c, oldColor, color);
        dfs(grid, i, j - 1, r, c, oldColor, color);
        dfs(grid, i + 1, j, r, c, oldColor, color);
    }
}