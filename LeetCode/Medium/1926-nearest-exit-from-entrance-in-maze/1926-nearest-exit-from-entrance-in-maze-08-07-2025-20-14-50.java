class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0}); // row, col, steps

        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1], steps = curr[2];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    maze[newRow][newCol] == '.' && !visited[newRow][newCol]) {

                    if (newRow == 0 || newRow == m - 1 || newCol == 0 || newCol == n - 1) {
                        return steps + 1;
                    }

                    queue.offer(new int[]{newRow, newCol, steps + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }
}