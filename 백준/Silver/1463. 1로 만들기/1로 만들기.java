import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[n] = 0;
        int index = 0;
        while(dp[1] == Integer.MAX_VALUE) {
            for(int i = 1; i < n + 1; i++) {
                if(dp[i] != index) continue;
                
                if(i % 3 == 0) dp[i / 3] = Math.min(index + 1, dp[i / 3]);
                if(i % 2 == 0) dp[i / 2] = Math.min(index + 1, dp[i / 2]);
                if(i - 1 >= 1) dp[i - 1] = Math.min(index + 1, dp[i - 1]);
            }

            index++;
        }
        
        System.out.println(dp[1]);
    }
}