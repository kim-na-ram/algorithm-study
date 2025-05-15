import java.util.*;

class Solution {
    public int n, m, count;
    public int[][] intStorage;
    public boolean[][] visited;
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        count = n * m;
        
        intStorage = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(intStorage[i], -1);
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                intStorage[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        
        for(String request : requests) {
            if(request.length() > 1) {
                crane(request.charAt(0) - 'A');
            } else {
                forkLift(request.charAt(0) - 'A');
            }
        }
        
        return count;
    }
    
    // 크레인으로 모든 타겟 컨테이너 제거
    public void crane(int target) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(target == intStorage[i][j]) {
                    count--;
                    intStorage[i][j] = -1;
                }
            }
        }
    }
    
    // 지게차로 접근 가능한 타겟 컨테이너만 제거
    public void forkLift(int target) {
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            if(!visited[i][0]) dfs(i, 0, target);
            if(!visited[i][m - 1]) dfs(i, m - 1, target);
        }
        for(int i = 0; i < m; i++) {
            if(!visited[0][i]) dfs(0, i, target);
            if(!visited[n - 1][i]) dfs(n - 1, i, target);
        }
    }
    
    public final int[] dx = {-1, 0, 1, 0};
    public final int[] dy = {0, -1, 0, 1};
    public void dfs(int x, int y, int target) {
        visited[x][y] = true;
        
        if(intStorage[x][y] == -1) {
            for(int i = 0; i < dx.length; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if(!visited[nextX][nextY]) dfs(nextX, nextY, target);
            }
        }
        if(intStorage[x][y] == target) {
            count--;
            intStorage[x][y] = -1;
        }
    }
}