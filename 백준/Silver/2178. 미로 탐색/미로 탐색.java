import java.util.*;
import java.io.*;

class Main {
    public static int N, M;
    public static int[][] miro;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        miro = new int[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                miro[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            for(int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M
                  || miro[nx][ny] == 0) continue;

                if(miro[nx][ny] != 1) continue;

                miro[nx][ny] = miro[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        return miro[N - 1][M - 1];
    }
}