import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] wines = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            wines[i] = sc.nextInt();
        }

        // dp[n][0] = 해당 번호의 포도주를 마시지 않음
        // dp[n][1] = 해당 번호의 포도주를 연속 1번 마심
        // dp[n][2] = 해당 번호의 포도주를 연속 2번 마심
        int[][] dp = new int[N + 1][3];
        dp[1][1] = wines[1];

        if(N >= 2) {
            dp[2][0] = dp[1][1];
            dp[2][1] = wines[2];
            dp[2][2] = dp[1][1] + wines[2];
        }

        for(int i = 3; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 2][0], Math.max(dp[i - 2][1], dp[i - 2][2])) + wines[i];
            dp[i][2] = dp[i - 1][1] + wines[i];
        }

        System.out.println(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])));
    }
}