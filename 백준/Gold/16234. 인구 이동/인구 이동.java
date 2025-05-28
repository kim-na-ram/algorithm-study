import java.util.*;
import java.io.*;

class Main {
    public static int N, L, R, days = 0;
    public static int[][] A;
    public static boolean move;
    public static boolean[][] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            move = false;
            checked = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!checked[i][j]) bfs(i, j);
                }
            }

            if(!move) break;
            else days++;
        }

        System.out.println(days);
    }

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void bfs(int x, int y) {
        List<int[]> unionList = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        unionList.add(new int[]{x, y});
        checked[x][y] = true;

        // 연합의 인구수
        int population = A[x][y];
        // 연합을 이루고 있는 칸의 개수
        int count = 1;
        
        while(!q.isEmpty()) {
            int[] pos = q.poll();

            for(int i = 0; i < dx.length; i++) {
                int nextX = pos[0] + dx[i];
                int nextY = pos[1] + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N
                      || checked[nextX][nextY]) continue;

                int gap = Math.abs(A[pos[0]][pos[1]] - A[nextX][nextY]);
                if(gap < L || R < gap) continue;

                move = true;
                q.offer(new int[]{nextX, nextY});
                unionList.add(new int[]{nextX, nextY});
                checked[nextX][nextY] = true;
                
                population += A[nextX][nextY];
                count++;
            }
        }

        if(move) {
            for(int[] union : unionList) {
                A[union[0]][union[1]] = (population / count);
            }
        }
    }
}