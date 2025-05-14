import java.util.*;

class Main {
    public static int N, M;
    public static int[][] maps;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        
        if(N == 1 && M == 1) {
            System.out.println(1);
            return;
        }
        
        maps = new int[N][M];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < M; j++) {
                maps[i][j] = s.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs());
    }

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int bfs() {
        int[][][] visited = new int[2][N][M];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while(true) {
            int[] current = q.poll();
            int w = current[0]; // wall
            int x = current[1];
            int y = current[2];

            for(int i = 0; i < dx.length; i++) {
                int nxtX = x + dx[i];
                int nxtY = y + dy[i];

                if(nxtX < 0 || nxtY < 0 || nxtX >= N || nxtY >= M) 
                    continue;
                
                if(maps[nxtX][nxtY] == 0) {
                    if(visited[w][nxtX][nxtY] == 0) {
                        q.offer(new int[]{w, nxtX, nxtY});
                        visited[w][nxtX][nxtY] = visited[w][x][y] + 1;
                        
                        if(nxtX == N - 1 && nxtY == M - 1) {
                            return visited[w][nxtX][nxtY];
                        }
                    }
                } else {
                    if(w == 0) {
                        if (visited[1][nxtX][nxtY] == 0) {
                            q.offer(new int[]{1, nxtX, nxtY});
                            visited[1][nxtX][nxtY] = visited[0][x][y] + 1;
                            if(nxtX == N - 1 && nxtY == M - 1) {
                                return visited[1][nxtX][nxtY];
                            }
                        }
                    }
                }

            }
                
            if(q.isEmpty()) return -1;
        }

    }
}