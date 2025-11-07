class Solution {
    private int[][] grid;
    private int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        grid = new int[m][n];
        
        for(int[] guard : guards) {
            int x = guard[0], y = guard[1];
            grid[x][y] = 1;
        }

        for(int[] wall : walls) {
            int x = wall[0], y = wall[1];
            grid[x][y] = 1;
        }

        for(int[] guard : guards) {
            int x = guard[0], y = guard[1];
            for(int d = 0; d < 4; d++) {
                int nx = x + directions[d][0];
                int ny = y + directions[d][1];

                dfs(nx, ny, d, m, n);
            }
        }
        
        int answer = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) answer++;
            }
        }

        return answer;
    }

    private void dfs(int x, int y, int d, int m, int n) {
        if(x < 0 || y < 0 || x >= m || y >= n) return;
        if(grid[x][y] == 1) return;
        
        grid[x][y] = 2;
        int nx = x + directions[d][0];
        int ny = y + directions[d][1];
        dfs(nx, ny, d, m, n);
    }
}