import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        int[][] dp = new int[41][2];

        dp[0][0] = 1;
        dp[1][1] = 1;

        StringBuilder sb = new StringBuilder();

        while(tc --> 0) {
            int N = sc.nextInt();

            for(int i = 2; i <= N; i++) {
                if(dp[i][0] == 0 && dp[i][1] == 0) {
                    dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
                    dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
                }
            }

            sb.append(dp[N][0] + " " + dp[N][1]).append("\n");
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}