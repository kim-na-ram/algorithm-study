import java.util.*;

class Solution {
    private int n;
    private int m;
    private boolean[][] visited;
    private int[][] map;
    private Queue<Dot> queue;
    private ArrayList<Integer> totalCount;
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        map = new int[n][m];
        queue = new LinkedList<Dot>();
        totalCount = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maps[i].charAt(j) == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        
        if(totalCount.size() <= 0) totalCount.add(-1);
        
        int[] answer = totalCount.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
    
    private int[] rowArr = {-1, 0, 1, 0};
    private int[] colArr = {0, -1, 0, 1};
    
    public void bfs(int i, int j) {
        queue.offer(new Dot(i, j));
        
        int count = map[i][j];
        visited[i][j] = true;
        
        while(!queue.isEmpty()) {
            Dot dot = queue.poll();
            
            for(int k = 0; k < 4; k++) {
                int row = dot.x + rowArr[k];
                int col = dot.y + colArr[k];
            
                if(checkDot(row, col)) {
                    visited[row][col] = true;
                    count += map[row][col];
                    queue.offer(new Dot(row, col));
                }
            }
        }
        
        totalCount.add(count);
    }
    
    public boolean checkDot(int i, int j) {
        if(i >= n || j >= m || i < 0 || j < 0) return false;
        if(map[i][j] == 0 || visited[i][j]) return false;
        
        return true;
    }
    
    class Dot {
        int x;
        int y;
        
        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}