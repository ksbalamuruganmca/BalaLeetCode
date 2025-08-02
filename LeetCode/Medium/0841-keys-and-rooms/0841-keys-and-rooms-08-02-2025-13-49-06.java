class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Code here
        int V = rooms.size();
        boolean[] visited = new boolean[V];

        dfs(0, rooms, visited);
        for (boolean roomVisited : visited) {
            if (!roomVisited) return false;
        }
        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;

        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}