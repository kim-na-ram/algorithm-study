import java.io.*;
import java.util.*;

class Main {
    public static int M, N;
    public static int[][] box;
    public static int count = 0;
    public static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] MN = br.readLine().split(" ");
        M = Integer.parseInt(MN[0]);
        N = Integer.parseInt(MN[1]);

        box = new int[N][M];
        queue = new LinkedList<int[]>();

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if(box[i][j] == 1) queue.offer(new int[]{i, j});
            }
        }

        bfs();
    }

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void bfs() {
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int pointX = point[0];
            int pointY = point[1];

            count = Math.max(count, box[pointX][pointY]);

            for(int i = 0; i < dx.length; i++) {
                int nextPointX = pointX + dx[i];
                int nextPointY = pointY + dy[i];

                if(nextPointX < 0 || nextPointX >= N || nextPointY < 0 || nextPointY >= M
                  || box[nextPointX][nextPointY] != 0) continue;

                box[nextPointX][nextPointY] = box[pointX][pointY] + 1;
                queue.offer(new int[]{nextPointX, nextPointY});
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(box[i][j] == 0) count = -1;
            }
        }

        System.out.println(count == -1 ? count : count - 1);
    }
}