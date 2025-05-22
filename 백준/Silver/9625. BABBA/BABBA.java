import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        // dp[K][0] : A의 개수
        // dp[K][1] : B의 개수
        int[][] dp = new int[K + 1][2];

        // 초기에는 "A" 부터 시작
        dp[0][0] = 1;
        for(int i = 1; i <= K; i++) {
            // A는 B 하나로 바뀐다
            // B는 B 하나
            dp[i][1] += dp[i - 1][0] + dp[i - 1][1];
            // A 하나로 바뀐다
            dp[i][0] += dp[i - 1][1];
        }

        System.out.println(dp[K][0] + " " + dp[K][1]);
    }
}