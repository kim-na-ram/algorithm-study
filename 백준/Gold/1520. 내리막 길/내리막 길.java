import java.util.*;
import java.io.*;

class Main {
    public static int M, N;
    public static int[][] maps, checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        maps = new int[M][N];
        checked = new int[M][N];

        for(int i = 0; i < M; i++) {
            Arrays.fill(checked[i], -1);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int dfs(int x, int y) {
        if(x == M - 1 && y == N - 1) {
            return 1;
        }
        
        if(checked[x][y] != -1) 
            return checked[x][y];

        checked[x][y] = 0;
        for(int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(maps[nx][ny] >= maps[x][y]) continue;
            checked[x][y] += dfs(nx, ny);
        }

        return checked[x][y];
    }
}