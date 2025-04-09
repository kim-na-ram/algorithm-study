import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int problemNumber = 1;
        StringBuilder sb = new StringBuilder();
        while(true) {
            int n = Integer.parseInt(br.readLine());
            
            if(n == 0) break;
            
            int[][] maps = new int[n][n];
            int[][] distance = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            
            for(int i = 0; i < n; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }
            
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            dijkstra(maps, distance, visited, n);
            
            sb.append("Problem ").append(problemNumber).append(": ")
                .append(distance[n-1][n-1]).append("\n");
            problemNumber++;
        }
        
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
    
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void dijkstra(int[][] maps, int[][] distance, boolean[][] visited, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));

        // x좌표, y좌표, pq 우선순위를 위한 최소값
        pq.offer(new int[]{0, 0, maps[0][0]});
        distance[0][0] = maps[0][0];
        
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            int nowX = arr[0];
            int nowY = arr[1];
            
            if(visited[nowX][nowY]) continue;
            visited[nowX][nowY] = true;
            
            for(int i = 0; i < 4; i++) {
                int nextX = arr[0] + dx[i];
                int nextY = arr[1] + dy[i];
                
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || visited[nextX][nextY]) continue;
                
                if(distance[nextX][nextY] > distance[nowX][nowY] + maps[nextX][nextY]) {
                    distance[nextX][nextY] = distance[nowX][nowY] + maps[nextX][nextY];
                    pq.offer(new int[]{nextX, nextY, distance[nextX][nextY]});
                }
            }
        }
    }
}