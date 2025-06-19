import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최대 15억이므로 int 로 커버 가능
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        for(int i = 0; i < N; i++) {
            if(i >= 1) 
                dp[i] = Math.max(dp[i], dp[i - 1]);
            
            if(i + T[i] <= N) 
                dp[i + T[i]] = Math.max(dp[i] + P[i], dp[i + T[i]]);
        }

        int max = 0;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);
    }
}