import java.util.*;
import java.io.*;

class Main {
    public static int N, M;
    public static int[][] field;
    public static boolean[][] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(T --> 0) {
            String[] s = br.readLine().split(" ");

            // 가로길이
            M = Integer.parseInt(s[0]);
            // 세로길이
            N = Integer.parseInt(s[1]);
            // 심겨진 배추의 개수
            int K = Integer.parseInt(s[2]);

            // 배추밭
            field = new int[N][M];

            StringTokenizer st;
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                // 배추가 심어진 곳
                field[Y][X] = 1;
            }

            int count = 0;
            checked = new boolean[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(field[i][j] == 1 && !checked[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});
        checked[x][y] = true;

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            for(int i = 0; i < dx.length; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M
                      || field[nx][ny] == 0 || checked[nx][ny]) continue;

                queue.offer(new int[]{nx, ny});
                checked[nx][ny] = true;
            }
        }
        
    }
}