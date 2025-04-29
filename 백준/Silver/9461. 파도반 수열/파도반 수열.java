import java.io.*;
import java.util.*;

class Main {
    public static int max = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while(tc --> 0) {
            int N = Integer.parseInt(br.readLine());
            
            long[] dp = new long[max + 1];
            
            dp[1] = dp[2] = dp[3] = 1;
            dp[4] = dp[5] = 2;

            if(N < 6) {
                sb.append(dp[N]).append("\n");
                continue;
            }

            int idx = 1;
            for(int i = 6; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[idx++];
            }

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}