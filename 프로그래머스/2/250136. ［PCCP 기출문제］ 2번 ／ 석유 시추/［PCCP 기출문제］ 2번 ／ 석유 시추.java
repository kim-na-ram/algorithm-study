import java.util.*;

class Solution {
    public static int n, m, petroleum = 1;
    public static boolean[][] visited;
    public static Map<Integer, Integer> map;
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        
        int max = 0;
        visited = new boolean[n][m];
        map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            int sum = 0;
            boolean[] checked = new boolean[petroleum + 1];
            for(int j = 0; j < n; j++) {
                if(land[j][i] != 0 && !checked[land[j][i]]) {
                    sum += map.get(land[j][i]);
                    checked[land[j][i]] = true;
                }
            }
            
            max = Math.max(max, sum);
        }
        
        return max;
    }
    
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int bfs(int x, int y, int[][] land) {
        Queue<int[]> queue = new LinkedList<int[]>();
        
        int sum = 1;
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            
            land[currentX][currentY] = petroleum;
            
            for(int i = 0; i < dx.length; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                
                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m
                        && !visited[nextX][nextY] && land[nextX][nextY] == 1) {
                    sum++;
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        
        map.put(petroleum, sum);
        petroleum += 1;
        return sum;
    }
}