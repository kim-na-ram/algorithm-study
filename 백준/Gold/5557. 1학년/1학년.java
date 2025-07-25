import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 20 이상의 숫자는 나올 수 없으므로
        long[][] dp = new long[N + 1][21];
        dp[1][numbers[1]] = 1;

        for(int i = 1; i < N - 1; i++) {
            for(int j = 0; j <= 20; j++) {
                if(dp[i][j] != 0) {
                    int plus = j + numbers[i + 1];
                    int minus = j - numbers[i + 1];

                    if(plus <= 20) dp[i + 1][plus] += dp[i][j];
                    if(minus >= 0) dp[i + 1][minus] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N - 1][numbers[N]]);

    }
}