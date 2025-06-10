import java.util.*;
import java.io.*;

class Main {
    public static int M, N, K;
    public static int[][] paper;
    public static boolean[][] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 행
        M = Integer.parseInt(st.nextToken());
        // 열
        N = Integer.parseInt(st.nextToken());
        // 직사각형 개수
        int K = Integer.parseInt(st.nextToken());

        paper = new int[M][N];
        checked = new boolean[M][N];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            // (x, y) 좌표가 (열, 행)이라 반대로 넣어줘야 함
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int n = x1; n < x2; n++) {
                for(int m = y1; m < y2; m++) {
                    paper[m][n] = 1;
                }
            }
        }

        int count = 0;
        List<Integer> areaList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(paper[i][j] == 0 && !checked[i][j]) {
                    count++;
                    areaList.add(bfs(i, j));
                }
            }
        }

        Collections.sort(areaList);

        sb.append(count).append("\n");
        for(int area : areaList) {
            sb.append(area).append(" ");
        }

        System.out.print(sb);
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();

        int area = 1;
        q.offer(new int[]{x, y});
        checked[x][y] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            for(int i = 0; i < dx.length; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N 
                   || paper[nx][ny] == 1 || checked[nx][ny]) continue;

                area++;
                q.offer(new int[]{nx, ny});
                checked[nx][ny] = true;
            }
            
        }

        return area;
    }
}