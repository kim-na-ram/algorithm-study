import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] dp = new long[N + 1];
        dp[1] = 4;

        if(N == 1) {
            System.out.println(dp[N]);
            return ;
        }

        dp[2] = 6;

        if(N <= 2) {
            System.out.println(dp[N]);
            return ;
        }

        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        System.out.println(dp[N]);
    }
}