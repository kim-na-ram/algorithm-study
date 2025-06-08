import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int maxHP = 99;
        int[] w = new int[N + 1];
        int[] v = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }
        
        // Knapsack 문제
        int[][] dp = new int[N + 1][maxHP + 1];
        
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= maxHP; j++) {
                if(w[i] <= j) dp[i][j] = Math.max(dp[i - 1][j - w[i]] + v[i], dp[i - 1][j]);
                else dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println(dp[N][maxHP]);
    }
}