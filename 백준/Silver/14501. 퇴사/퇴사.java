import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] Ti = new int[N + 1];
        int[] Pi = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            Ti[i] = sc.nextInt();
            Pi[i] = sc.nextInt();
        }

        int[] dp = new int[N + 1];
        for(int i = 0; i < N; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            
            int targetDate = i + Ti[i + 1];
            if(targetDate <= N) {
                dp[targetDate] = Math.max(dp[i] + Pi[i + 1], dp[targetDate]);
            }
        }

        System.out.println(dp[N]);
    }
}