class Solution {
    public int n;
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, -1, 0, 1};
    public int swimInWater(int[][] grid) {
        n = grid.length;

        return bfs(0, 0, grid);
    }

    public int bfs(int x, int y, int[][] grid) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[3] - o2[3]);
        boolean[][] visited = new boolean[n][n];

        q.offer(new int[]{x, y, 0, grid[x][y]});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int t = pos[2];

            for(int i = 0; i < dx.length; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) continue;

                q.offer(new int[]{nx, ny, t + 1, grid[nx][ny]});
                grid[nx][ny] = Math.max(t + 1, Math.max(grid[nx][ny], grid[pos[0]][pos[1]]));
                visited[nx][ny] = true;
            }
        }

        return grid[n - 1][n - 1];
    }
}