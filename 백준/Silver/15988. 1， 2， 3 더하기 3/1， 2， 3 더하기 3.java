import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for(int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }

        StringBuilder sb = new StringBuilder();

        while(T --> 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n]).append("\n");
        }
        
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}