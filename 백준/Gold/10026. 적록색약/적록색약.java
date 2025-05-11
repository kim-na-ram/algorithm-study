import java.util.*;
import java.io.*;

class Main {
    public static int N, sum = 0, sumForRGB = 0;
    public static char[][] area;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        area = new char[N][N];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < N; j++) {
                area[i][j] = s.charAt(j);
            }
        }

        boolean[][] visited1 = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited1[i][j]) {
                    bfs(i, j, visited1);
                    sum++;
                }

                if(!visited2[i][j]) {
                    bfs_forRGB(i, j, visited2);
                    sumForRGB++;
                }
            }
        }

        System.out.println(sum + " " + sumForRGB);
    }

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<int[]>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i = 0; i < dx.length; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N 
                   || visited[nextX][nextY] || area[x][y] != area[nextX][nextY]) continue;

                q.offer(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }
    }
    
    public static void bfs_forRGB(int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<int[]>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i = 0; i < dx.length; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N 
                   || visited[nextX][nextY]) continue;

                // 적록색약일 경우
                if(area[x][y] != area[nextX][nextY]) {
                    if(area[x][y] == 'B') continue;
                    if(area[x][y] == 'R' && area[nextX][nextY] == 'B') continue;
                    if(area[x][y] == 'G' && area[nextX][nextY] == 'B') continue;
                }

                q.offer(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }
    }
}