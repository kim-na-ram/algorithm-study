import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int answer = -1;
        
        int[][] visited = new int[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            
            for(int i = 0; i < dx.length; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || maps[nextX][nextY] == 0 || visited[nextX][nextY] != 0) continue;
                
                visited[nextX][nextY] = visited[currentX][currentY] + 1;
                queue.offer(new int[]{nextX, nextY});
            }
        }
        
        return visited[n - 1][m - 1] == 0 ? answer : visited[n - 1][m - 1];
    }
}