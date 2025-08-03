class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int fresh = 0;
        int rotten = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 2) {
                    rotten++;
                    queue.offer(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0)
            return 0;
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int min = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && nx < row && ny >= 0 && ny < column && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        fresh--;
                        rottedThisMinute = true;
                        queue.offer(new int[] { nx, ny });
                    }
                }
            }

            if (rottedThisMinute)
                min++;
        }

        return fresh == 0 ? min : -1;
    }
}