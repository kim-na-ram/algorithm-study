import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];
            for(int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M + 1];

            for (int coin : coins) {
                for (int j = 1; j <= M; j++) {
                    if (j - coin > 0) {
                        dp[j] = dp[j] + dp[j - coin];
                    } else if (j - coin == 0) {
                        dp[j]++;
                    }
                }
            }
            sb.append(dp[M] + "\n");
        }
        
        System.out.print(sb);
    }
}