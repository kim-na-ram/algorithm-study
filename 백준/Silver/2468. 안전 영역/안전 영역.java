import java.util.*;
import java.io.*;

class Main {
    public static int N;
    public static int[][] maps;
    public static boolean[][] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];

        int min = 0, max = 0;
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, maps[i][j]);
                max = Math.max(max, maps[i][j]);
            }
        }

        int maxSafeAreaCount = 0;
        for(int r = min; r <= max; r++) {
            int safeAreaCount = 0;
            checked = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(maps[i][j] > r && !checked[i][j]) {
                        bfs(r, i, j);
                        safeAreaCount += 1;
                    }
                }
            }

            maxSafeAreaCount = Math.max(safeAreaCount, maxSafeAreaCount);
        }
        
        System.out.println(maxSafeAreaCount);
    }

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void bfs(int rain, int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();

        q.offer(new int[]{x, y});
        checked[x][y] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            for(int i = 0; i < dx.length; i++) {
                int nxtX = pos[0] + dx[i];
                int nxtY = pos[1] + dy[i];

                if(nxtX < 0 || nxtY < 0 || nxtX >= N || nxtY >= N 
                   || checked[nxtX][nxtY] || maps[nxtX][nxtY] <= rain) continue;

                q.offer(new int[]{nxtX, nxtY});
                checked[nxtX][nxtY] = true;
            }
        }
    }
}