import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 단원의 개수
        int N = Integer.parseInt(st.nextToken());

        // 공부할 수 있는 총 시간
        int T = Integer.parseInt(st.nextToken());

        int[][] sections = new int[N + 1][2];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            // 단원 별 예상 공부 시간
            sections[i][0] = Integer.parseInt(st.nextToken());

            // 단원 문제의 배점
            sections[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][T + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= T; j++) {
                if(sections[i][0] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - sections[i][0]] + sections[i][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.print(dp[N][T]);
    }
}