import java.util.*;

class Solution {
    public static int w, h, numberOfArea, maxSizeOfOneArea;
    public static int[][] checked;
    public int[] solution(int m, int n, int[][] picture) {
        w = n;
        h = m;
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        
        checked = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 0) continue;
                if(checked[i][j] == 0) {
                    numberOfArea += 1;
                    bfs(i, j, picture);
                }
            }
        }
        
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
    
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public void bfs(int x, int y, int[][] picture) {
        Queue<int[]> queue = new LinkedList<>();
        
        int areaCount = 1;
        queue.offer(new int[]{x, y});
        checked[x][y] = numberOfArea;
        
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            
            for(int i = 0; i < dx.length; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= h || ny >= w 
                   || checked[nx][ny] != 0 || picture[x][y] != picture[nx][ny]) continue;
                
                areaCount++;
                queue.offer(new int[]{nx, ny});
                checked[nx][ny] = numberOfArea;
            }
        }
        
        maxSizeOfOneArea = Math.max(areaCount, maxSizeOfOneArea);
    }
}