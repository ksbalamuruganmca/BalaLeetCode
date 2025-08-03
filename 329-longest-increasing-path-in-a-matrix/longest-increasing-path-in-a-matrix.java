class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] res = new int[r][c];
        int ans = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans = Math.max(ans, dfs(matrix, res, i, j, r, c));
            }
        }
        return ans;
    }

    int dfs(int[][] mat, int[][] res, int i, int j, int r, int c) {
        if (res[i][j] != 0) return res[i][j];

        int val = mat[i][j];
        int maxLen = 0;

        if (i > 0 && mat[i - 1][j] > val) {
            maxLen = Math.max(maxLen, dfs(mat, res, i - 1, j, r, c));
        }
        if (j > 0 && mat[i][j - 1] > val) {
            maxLen = Math.max(maxLen, dfs(mat, res, i, j - 1, r, c));
        }
        if (i + 1 < r && mat[i + 1][j] > val) {
            maxLen = Math.max(maxLen, dfs(mat, res, i + 1, j, r, c));
        }
        if (j + 1 < c && mat[i][j + 1] > val) {
            maxLen = Math.max(maxLen, dfs(mat, res, i, j + 1, r, c));
        }
        return res[i][j] = maxLen + 1;
    }
}