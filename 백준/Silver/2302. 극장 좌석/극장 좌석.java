import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        // N = 1
        // 1
        // N = 2
        // 1, 2 or 2, 1
        // N = 3
        // 1, 2, 3 or 2, 1, 3 or 1, 3, 2
        // N = 4
        // 1, 2, 3, 4 or 2, 1, 3, 4 or 2, 1, 4, 3 or 1, 3, 2, 4 or 1, 2, 4, 3

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 고정석이 있을 때
        // 만약 N = 4에서 3이 고정석이라면
        // 1, 2, 3, 4 or 2, 1, 3, 4
        // dp[2] * dp[1]
        // 만약 N = 4에서 4가 고정석이라면
        // 1, 2, 3, 4 or 2, 1, 3, 4 or 1, 3, 2, 4
        // dp[3] * dp[0]
        
        int answer = 1;
        int before = 0;
        for(int i = 0; i < M; i++) {
            int tmp = sc.nextInt();
            answer *= dp[tmp - before - 1];
            before = tmp;
        }

        answer *= dp[N - before];

        System.out.print(answer);
    }
}