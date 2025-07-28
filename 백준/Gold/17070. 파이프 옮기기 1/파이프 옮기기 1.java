import java.util.*;
import java.io.*;

class Main {
    public static int N;
    public static int[][] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        house = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 2, 0);
        System.out.print(ans);        
    }

    public static int ans = 0;
    public static void dfs(int r, int c, int direction) {
        if(r == N && c == N) {
            ans++;
            return;
        }

        switch(direction) {
            case 0: // 가로
                if(c + 1 <= N && house[r][c + 1] == 0) {
                    dfs(r, c + 1, 0);
                }
                break;
            case 1: // 대각선
                if(c + 1 <= N && house[r][c + 1] == 0) {
                    dfs(r, c + 1, 0);
                }

                if(r + 1 <= N && house[r + 1][c] == 0) {
                    dfs(r + 1, c, 2);
                }
                break;
            case 2: // 세로
                if(r + 1 <= N && house[r + 1][c] == 0) {
                    dfs(r + 1, c, 2);
                }
                break;
        }

        if(r + 1 <= N && c + 1 <= N && house[r][c + 1] == 0 
           && house[r + 1][c + 1] == 0 && house[r + 1][c] == 0)
            dfs(r + 1, c + 1, 1);
    }
}